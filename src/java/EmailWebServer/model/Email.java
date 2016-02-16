/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailWebServer.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author huan
 */
@Entity
public class Email implements EmailDTO, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emailNo;
    private String email;
    

    /**
     * Creates a new instance of Account
     */
    public Email() {
    }
    
    public Email(String email) {
        this.email = email;    
    }
    
    public String getEmail() {
        return email;
    }

    public int getEmailNo()
    {
        return emailNo;
    }
    
    @Override
    public String toString() {
        return "email"+ email;
    }
    
}
