package beans;

import javax.faces.bean.ManagedBean;
import java.sql.Date;
import models.Book;
import DAO.BookDAO;

@ManagedBean(name = "bookBean")
public class BookBean {

    private String title;
    private String author;
    private String publishingHouse;
    private String year;
    private String genre;
    private Date dateAdded;
    private String synopsis;
    private String status;
    private BookDAO bookDao = new BookDAO();

    public BookBean() {

    }

    public void insert() throws Exception {
        long millis = System.currentTimeMillis();
        dateAdded = new Date(millis);
        status = "N";
        Book book = new Book(title, author, publishingHouse, year, genre, dateAdded, synopsis, status);
        bookDao.insert(book);
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
