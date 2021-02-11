/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import databaseConnection.EntityManagerProvider;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import models.User;
//import models.User;

/**
 *
 * @author user
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;
    private User user;
    private String outputMessage="";
    public LoginBean() {
    }

    public String login() {
            boolean isUserAuthenticated = authenticateUser();
            if (!isUserAuthenticated) {
                return "login";
            } 
            else{
                outputMessage="";
                if("admin".equals(user.getUserType())) return "indexAdmin";
                else return "indexStandard";
            }
    }
    
    private boolean authenticateUser(){
        EntityManager em = EntityManagerProvider.getEntityManager();
        String getUserQuery = "SELECT u FROM User u WHERE u.email=:email";
        
        List<User> users = em.createQuery(getUserQuery)
                .setParameter("email", email)
                .getResultList();
        if (users.isEmpty()) {
            email="";
            outputMessage = "Incorrect email.";
            return false;
        }
        user = users.get(0);
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            outputMessage = "Incorrect password.";
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
    
    
}
