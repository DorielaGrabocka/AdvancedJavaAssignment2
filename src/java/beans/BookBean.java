package beans;

import javax.faces.bean.ManagedBean;
import java.util.Date;
import models.Book;
import DAO.BookDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

@ManagedBean(name = "bookBean")
public class BookBean {

    private String title;
    private String author;
    private String publishingHouse;
    private String publicationYear;
    private String genre;
    private Date dateAdded;
    private String synopsis;
    private String status;
    private BookDAO bookDao = new BookDAO();
    private String outputMessage;

    public BookBean() {

    }

    public void insert() throws Exception {
        boolean exists = bookDao.bookExists(title, publicationYear);
        if (!exists) {
            long millis = System.currentTimeMillis();
            dateAdded = new Date(millis);
            status = "N";
            Book book = new Book(title, author, publishingHouse, publicationYear, genre, dateAdded, synopsis, status);
            bookDao.insert(book);
            FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("booksPage.xhtml");
        }
        else{
            outputMessage = "Book already exists!";
        }
    }
    
    public List<Book> getAll(){
        return bookDao.getAll();
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

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
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

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }
}
