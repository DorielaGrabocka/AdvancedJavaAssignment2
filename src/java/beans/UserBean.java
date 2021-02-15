/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.UserDAO;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.User;

/**
 *
 * @author Doriela
 */
@ManagedBean
@ViewScoped
public class UserBean {

    private UserDAO userDAO;
    
    private String id;
    private boolean editing;
    private String name;
    private String surname;
    private String email;
    private String userType;
    private String message;
    private User user;
    private String deleteMessage;
    
    public UserBean() {
        userDAO = new UserDAO();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<User> getAllUsers(){
        return userDAO.getAll();
    }
    
    public void setUser(User u){
        this.user = u;
    }
    
    public User getUser(){
        return user;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }
    
    public void fillData(){
        clear();
        editing=true;
        Map<String, String> parameters = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        int id = Integer.parseInt(parameters.get("userId"));
        
        User u = userDAO.getById(id);
        name = u.getName();
        surname = u.getSurname();
        email = u.getEmail();
        userType = u.getUserType();
        setUser(u);
    }
    
    public void save() throws Exception{
        try{
            if (editing) {//we are editing
                
                User u = userDAO.getById(user.getId());
                u.setName(name);
                u.setSurname(surname);
                u.setEmail(email);
                u.setUserType(userType);
                userDAO.update(u);//update user
                message="User updated succesfully!";
                clear();
            } 
            else{//we are inserting
                //message="Inside insert";
                /*if(userDAO.getUserByEmail(email)!=null){
                    message+="User with this email already exists!";
                }*/
                //else{
                    User u = new User();
                    u.setName(name);
                    u.setSurname(surname);
                    u.setEmail(email);
                    u.setPassword(encrypt("user"));
                    u.setStatus('N');//set user status to NOT DELETED
                    u.setUserType(userType);
                    userDAO.insert(u);//add user
                    message="User added succesfully! Check users table";
                //}
            }
        }catch(Exception e){
            message="An error has occured! New Email might already be taken!";
        }
    }
    
    /**Utility method to clear the view after an insert or delete.*/
    public void clear(){
        name="";
        surname="";
        email="";
        deleteMessage="";
        if(!editing)
            message="";
        editing=false;
    }
    
    private String encrypt(String pass){
        return Base64.getEncoder().encodeToString(pass.getBytes());
    }
    
    
    /**Method to mark a user as deleted in a database.
     * 
     */
    public void delete(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String sID = params.get("userId");
        int id = Integer.parseInt(sID);
        User proccessedUser = userDAO.getById(id);
        proccessedUser.setStatus('D');
        userDAO.update(proccessedUser);
    }
}
