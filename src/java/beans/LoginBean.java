/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.UserDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    public void login() throws IOException{
            outputMessage="";
            boolean isUserAuthenticated = authenticateUser();
            
            if (!isUserAuthenticated) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("login.xhtml");
            } 
            else{
                outputMessage="";
                if("standard".equals(user.getUserType())) 
                    FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("indexStandard.xhtml");
                else 
                    FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("indexAdmin.xhtml");
            }
            
            /*if (!isUserAuthenticated) {
                return "login";
            } 
            else{
                outputMessage="";
                if("admin".equals(user.getUserType())) return "indexAdmin";
                else return "indexStandard";
            }*/
    }
    
    private boolean authenticateUser(){
        
        UserDAO userDAO = new UserDAO();
        
        try{
            User potentialUser = userDAO.getUserByEmail(email);
            if (potentialUser == null) {
                email = "";
                outputMessage = "Incorrect email.";
                return false;
            }

            if (password.equals(potentialUser.getPassword())) {
                user = potentialUser;
                return true;
            } else {
                outputMessage = "Incorrect password.";
                return false;
            }
        }catch(Exception e){
            email = "";
            outputMessage = "Incorrect email.";
            return false;
        }  
    }

    /**Method to check if a user is logged in or not. If yes then, go to the specific
     * page, else redirect to the login page.
     * @return the page were it will land
     */
    public String isUserLoggedIn(){
        try{
            if(user==null){
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("login.xhtml");
            }
        }catch(IOException e){
            return "login.xhtml";
        }
         return "";
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

    public User getUser() {
        return user;
    }
    
    
    
    
}
