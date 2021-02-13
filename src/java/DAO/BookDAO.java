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
import models.Book;

/**
 *
 * @author Doriela
 */
public class BookDAO implements BaseDao<Book>{
    
    @Override
    public EntityManager getEntityManager() {
        return EntityManagerProvider.getEntityManager();
    }

    @Override
    public void insert(Book b) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction transcation = em.getTransaction();
        transcation.begin();
        em.persist(b);
        transcation.commit();
    }
    
    @Override
    public void delete(Book b) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction transcation = em.getTransaction();
        transcation.begin();
        em.remove(b);
        transcation.commit();
    }

    @Override
    public void update(Book updatedBook) throws Exception {
        EntityManager em = getEntityManager();
        Book original = em.find(Book.class, updatedBook.getId());
        updateBook(original, updatedBook);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(original);
        transaction.commit();
    }

    /**Method that gets the book with the original values and the book with new values
    * It updates the updatable parameters(title, author, genre, publication year, 
    * publishing house, synopsis, status) of the book.
    * @param original  - the book with unchanged data
    * @param updated -book with new parameters.*/
    private void updateBook(Book original, Book updated){
        original.setTitle(updated.getTitle());
        original.setAuthor(updated.getAuthor());
        original.setGenre(updated.getGenre());
        original.setPublicationYear(updated.getPublicationYear());
        original.setPublishingHouse(updated.getPublishingHouse());
        original.setSynopopsis(updated.getSynopopsis());
        original.setStatus(updated.getStatus());
    }

    @Override
    public Book getById(int id) {
        return (Book)getEntityManager().createNamedQuery("Book.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
    
    @Override
    public List<Book> getAll(){
        return getEntityManager().createNamedQuery("Book.findAll")
               .getResultList();
    }
    
    /**Method to get the last five added books to the database
     * @return the list of books 
     */
    public List<Book> getLastFive(){
        String query = "SELECT b FROM Book b ORDER BY b.dateAdded DESC";
        return getEntityManager().createQuery(query, Book.class)
                .setMaxResults(5)
                .getResultList();
    }
    
    /**Method to get the top five rated books.
     * @return the list of books 
     */
    public List<Book> getTopFive(){
        String query="SELECT b "
                + "FROM Book b JOIN Review r on b.id=r.reviewPK.bookID "
                + "GROUP By b.id "
                + "ORDER BY AVG(r.rating) DESC ";
        
        return getEntityManager().createQuery(query, Book.class)
                .setMaxResults(5)
                .getResultList();
    }
    
    /**Method to get the average rating of a book
     *@param id - is the primary key of the book in the table
     *@return the average rating of the book or 0 if no rating exists
     */
    public double getAverageRating(int id){
        String query="SELECT r.rating FROM Review r WHERE r.reviewPK.bookID = :bookID";
        
        return getEntityManager().createQuery(query, Integer.class)
                .setParameter("bookID", id)
                .getResultList()
                .stream()
                .mapToInt(r -> r)
                .average()
                .orElse(0);
    }
}
