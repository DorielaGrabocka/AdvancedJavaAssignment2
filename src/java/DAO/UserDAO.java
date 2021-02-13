/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databaseConnection.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.User;

/**
 *
 * @author Doriela
 */
public class UserDAO implements BaseDao<User>{

    @Override
    public void insert(User user) throws Exception{
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    @Override
    public void delete(User user) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(user);
        transaction.commit();
    }

    @Override
    public void update(User userUpdated) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, userUpdated.getId());
        updateUser(user, userUpdated);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(user);
        transaction.commit();
    }
    
    /**Method that gets the user with the original values and the user with new values
    * It updates the updatable parameters(name, surname, email, password and user type) of the user.
    * @param user - the user with unchanged data
    * @param updatedUser -user with new parameters.
    */
    private void updateUser(User user, User updatedUser){
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setStatus(updatedUser.getStatus());
    }

    @Override
    public EntityManager getEntityManager() {
        return EntityManagerProvider.getEntityManager();
    }
    
    /**Method that find and returns a user by a specific id.
     *@param id- is the corresponding primary key of the user in the table
     * @return the corresponding User object.
     */
    @Override
    public User getById(int id){
        EntityManager em = getEntityManager();
        User user = (User) em.createNamedQuery("User.findById", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }
    
    /**Method that find and returns a user by a specific id.
     *@param email- is the corresponding user email
     *@return the corresponding User object.
     */
    public User getUserByEmail(String email) throws Exception{
        EntityManager em = getEntityManager();
        User user = (User) em.createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return user;
    }
    
    /**Method to return all the users in the database.
     *@return a list of users
     */
    @Override
    public List<User> getAll(){
        return getEntityManager().createNamedQuery("User.findAll", User.class)
                .getResultList();
    }
    
}
