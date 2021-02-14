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
import models.Review;

/**
 *
 * @author Doriela
 */
public class ReviewDAO implements BaseDao<Review>{
 
    @Override
    public EntityManager getEntityManager() {
        return EntityManagerProvider.getEntityManager();
    }

    @Override
    public void insert(Review r) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(r);
        transaction.commit();
    }

    @Override
    public void delete(Review r) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(r);
        transaction.commit();
    }

    public Review getByIds(int userId, int bookID) {
        String query = "SELECT r FROM Review r "
                + "WHERE r.reviewPK.userID = :userID AND r.reviewPK.bookID";
        return getEntityManager().createQuery(query, Review.class)
                .setParameter("userID", userId)
                .setParameter("bookID", bookID)
                .getSingleResult();
    }

    @Override
    public List<Review> getAll() {
        return getEntityManager().createNamedQuery("Review.findAll")
                .getResultList();
    }
    
}
