/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import databaseConnection.EntityManagerProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import models.Book;
import models.Review;
import models.ReviewPK;
import models.User;

/**
 *
 * @author Doriela
 */
public class BookDAO implements BaseDao<Book> {

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
        boolean exists = bookExists(b.getTitle(), b.getPublicationYear()) != null;
        if (!exists) {
            transcation.begin();
            em.remove(b);
            transcation.commit();
        }
    }

    public void update(Book updatedBook) throws Exception {
        EntityManager em = getEntityManager();
        Book original = em.find(Book.class, updatedBook.getId());
        updateBook(original, updatedBook);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(original);
        transaction.commit();
    }

    /**
     * Method that gets the book with the original values and the book with new
     * values It updates the updatable parameters(title, author, genre,
     * publication year, publishing house, synopsis, status) of the book.
     *
     * @param original - the book with unchanged data
     * @param updated -book with new parameters.
     */
    private void updateBook(Book original, Book updated) {
        original.setTitle(updated.getTitle());
        original.setAuthor(updated.getAuthor());
        original.setGenre(updated.getGenre());
        original.setPublicationYear(updated.getPublicationYear());
        original.setPublishingHouse(updated.getPublishingHouse());
        original.setSynopsis(updated.getSynopsis());
        original.setStatus(updated.getStatus());
    }

    /**
     * Method to get a book by the id.
     *
     * @param id- is the primary key of the book on the table in the database.
     * @return the corresponding book.
     */
    public Book getById(int id) {
        //try {
        //   return (Book) getEntityManager().createNamedQuery("Book.findById")
        //         .setParameter("id", id)
        //       .getSingleResult();
        //} catch (NoResultException e) {
        //    return null;
        // }
        return getEntityManager().find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        return getEntityManager().createNamedQuery("Book.findAll")
                .getResultList();
    }

    /**
     * Method to get the last five added books to the database
     *
     * @return the list of books
     */
    public List<Book> getLastFive() {
        String query = "SELECT b FROM Book b WHERE b.status!='D' ORDER BY b.dateAdded DESC";
        return getEntityManager().createQuery(query, Book.class)
                .setMaxResults(5)
                .getResultList();
    }

    /**
     * Method to get the top five rated books.
     *
     * @return the list of books
     */
    public List<Book> getTopFive() {
        String query = "SELECT b "
                + "FROM Book b JOIN Review r on b.id=r.reviewPK.bookID "
                + "WHERE b.status!='D' "
                + "GROUP By b.id "
                + "ORDER BY AVG(r.rating) DESC ";

        return getEntityManager().createQuery(query, Book.class)
                .setMaxResults(5)
                .getResultList();
    }

    /**
     * Method to get the average rating of a book
     *
     * @param id - is the primary key of the book in the table
     * @return the average rating of the book or 0 if no rating exists
     */
    public double getAverageRating(int id) {
        String query = "SELECT r.rating FROM Review r WHERE r.reviewPK.bookID = :bookID";

        return getEntityManager().createQuery(query, Integer.class)
                .setParameter("bookID", id)
                .getResultList()
                .stream()
                .mapToInt(r -> r)
                .average()
                .orElse(0);
    }

    public Book bookExists(String title, String publicationYear) {
        String query = "SELECT b FROM Book b WHERE b.title=:title "
                + "AND b.publicationYear=:publicationYear";
        try {
            Book foundBook = getEntityManager().createQuery(query, Book.class)
                    .setParameter("title", title)
                    .setParameter("publicationYear", publicationYear)
                    .getSingleResult();

            return foundBook;
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Method to get books that have average rating greater than specified value
     *
     * @param averageRating is the lower bound of the rating that we are
     * searching for
     * @return the list of books
     */
    public List<Book> getAllBookWithAverageRatingGreaterThan(int averageRating) {
        String query = "SELECT b "
                + "FROM Book b join Review r ON b.id=r.reviewPK.bookID "
                + "WHERE b.status!='D'"
                + "GROUP BY r.reviewPK.bookID "
                + "HAVING avg(r.rating)>:value";

        return getEntityManager().createQuery(query)
                .setParameter("value", averageRating)
                .getResultList();
    }

    public List<Book> filterBooks(String title, String author,
            int min, int max, String genre) {
        String query = "SELECT b FROM Book b WHERE b.status !='D' ";
        if (title != null && !title.equals("")) {
            query += " AND LOWER(b.title) LIKE LOWER(:title)";
        }
        if (author != null && !author.equals("")) {
            query += " AND LOWER(b.author) LIKE LOWER(:author)";
        }
        if (genre != null && !genre.equals("")) {
            query += " AND LOWER(b.genre) LIKE LOWER(:genre)";
        }

        TypedQuery<Book> tQuery = getEntityManager().createQuery(query, Book.class);
        if (title != null && !title.equals("")) {
            tQuery.setParameter("title", title + "%");
        }
        if (author != null && !author.equals("")) {
            tQuery.setParameter("author", author + "%");
        }
        if (genre != null && !genre.equals("")) {
            tQuery.setParameter("genre", genre + "%");
        }
        List<Book> filteredBooks = tQuery.getResultList();
        List<Book> filteredByMinMax = new ArrayList<>();
        if (min != 0 || max != 0) {
            filteredByMinMax = filterByRange(filteredBooks, min, max);

            return filteredByMinMax;
        }
        return filteredBooks;
    }

    private List<Book> filterByRange(List<Book> books, int min, int max) {
        if (min != 0 && max != 0) {
            return books.stream()
                    .filter(b -> getAverageRating(b.getId()) > min && getAverageRating(b.getId()) <= max)
                    .collect(Collectors.toList());
        } else if (min != 0) {
            return books.stream()
                    .filter(b -> getAverageRating(b.getId()) > min)
                    .collect(Collectors.toList());
        } else if (max != 0) {
            return books.stream()
                    .filter(b -> getAverageRating(b.getId()) <= max)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
