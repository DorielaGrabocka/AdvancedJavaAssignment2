/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import databaseConnection.EntityManagerProvider;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    private String outputMessage;
    public LoginBean() {
    }

    public String login() {
            boolean isUserAuthenticated = authenticateUser();
            if (!isUserAuthenticated) {
                email="";
                outputMessage = "Invalid Password, please try again!";
                return "";
            } 
            else{
                outputMessage="";
                return "success";
            }
    }
    
    private boolean authenticateUser(){
        EntityManager em = EntityManagerProvider.getEntityManager();
        String getUserQuery = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password"; 
        try{
         User user = (User)em.createQuery(getUserQuery)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        
        }
        catch(NoResultException e){
            outputMessage = e.toString();
            return false;
        }
        return true;
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
