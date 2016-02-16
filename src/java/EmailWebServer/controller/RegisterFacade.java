/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailWebServer.controller;

import EmailWebServer.model.CurrencyNotFoundException;
import EmailWebServer.model.Email;
import EmailWebServer.model.EmailDTO;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author huan
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class RegisterFacade {
    @PersistenceContext(unitName = "RegisterPU")
    private EntityManager em;
    
    
    /**
     * 
     * @param email
     * @return 
     */
    public EmailDTO register(String email)
    {
        Email newEmail = new Email(email);
        em.persist(newEmail);
        return newEmail;
    }

    
}

