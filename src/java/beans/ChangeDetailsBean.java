/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import models.User;

/**
 *
 * @author Doriela
 */
@ManagedBean
@RequestScoped
public class ChangeDetailsBean {
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean; 
    
    private User user;
    private String currentPassowrd="abc";
    private String newPassword;
    private String confirmNewPassword;
        
    public ChangeDetailsBean() {
        
    }

    public User getCurrentUser() {
        return loginBean.getUser();
    }

    public String getName() {
        return getCurrentUser().getName();
    }

    public String getEmail() {
        return getCurrentUser().getEmail();
    }

    public String getSurname() {
        return getCurrentUser().getSurname();
    }

    public void setName(String name) {
        getCurrentUser().setName(name);
    }

    public void setEmail(String email) {
        getCurrentUser().setEmail(email);
    }

    public void setSurname(String surname) {
        getCurrentUser().setSurname(surname);
    }
 
    public void setCurrentPassowrd(String currentPassowrd) {
        this.currentPassowrd = currentPassowrd;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getCurrentPassowrd() {
        return currentPassowrd;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    
           
    public void updateProfile(){
        
    }
    
    public void updatePassword(){
        
    }
    
}
