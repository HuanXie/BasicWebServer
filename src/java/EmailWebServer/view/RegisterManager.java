/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailWebServer.view;

import EmailWebServer.controller.RegisterFacade;
import EmailWebServer.model.EmailDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author huan
 */
@Named("RegisterManager")
@ConversationScoped
public class RegisterManager implements Serializable{
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private RegisterFacade registerFacade;
    private String email;
    private String returnemail;
    private EmailDTO newEmail;
    private Exception conversionFailure;
    @Inject
    private Conversation conversation;
    
    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    private void handleException(Exception e) {
        stopConversation();
        e.printStackTrace(System.err);
        conversionFailure = e;
    }

    
    /**
     * @return <code>true</code> if the latest transaction succeeded, otherwise
     * <code>false</code>.
     */
    public boolean getSuccess() {
        return conversionFailure == null;
    }

    /**
     * Returns the latest thrown exception.
     */
    public Exception getException() {
        return conversionFailure;
    }

    /**
     * This return value is needed because of a JSF 2.2 bug. Note 3 on page 7-10
     * of the JSF 2.2 specification states that action handling methods may be
     * void. In JSF 2.2, however, a void action handling method plus an
     * if-element that evaluates to true in the faces-config navigation case
     * causes an exception.
     *
     * @return an empty string.
     */
    private String jsf22Bugfix() {
        return "";
    }

    /**
     * Searches for the account specified by the latest call to
     * <code>setSearchedAcct</code>.
     */
    public String register() {
        try {
            startConversation();
            conversionFailure = null;
            newEmail = registerFacade.register(email);
            returnemail = newEmail.getEmail();
        } catch (Exception e) {
            handleException(e);
        }
        return jsf22Bugfix();
    }

    /**
     * Creates a currency table.
     */
    



    /**
     * Set the value of returnemail
     *
     * @param returnemail 
     */
    public void setReturnemail(String returnemail) {
        this.returnemail = returnemail;
    }
    
    public String getReturnemail() {
        return returnemail;
    }
    
    
    
    
    /**
     * Set the value of email
     *
     * @param email new value of newAccountBalance
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    
}
