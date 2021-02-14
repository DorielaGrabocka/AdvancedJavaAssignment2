package beans;

import javax.faces.bean.ManagedBean;
import java.util.Date;
import models.Book;
import DAO.BookDAO;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "bookBean")
@ViewScoped
public class BookBean {

    private int id;
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
    private Book updatedBook = new Book();

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
        } else {
            outputMessage = "Book already exists!";
        }
    }

    public List<Book> getAll() {
        List<Book> booksToShow = new ArrayList<>();
        bookDao.getAll()
                .stream()
                .filter(b -> (b.getStatus().equals("N")))
                .forEachOrdered(b -> {booksToShow.add(b);});
        return booksToShow;
    }

    public void fillData() throws IOException, ParseException {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.id = Integer.parseInt(params.get("bookId"));
        updatedBook = bookDao.getById(id);
        populateFields(updatedBook);
    }

    public void edit() throws Exception {
        populateModel(updatedBook);
        bookDao.update(updatedBook);
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("booksPage.xhtml");
    }
    
    public void populateModel(Book book){
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setDateAdded(this.dateAdded);
        book.setGenre(this.genre);
        book.setPublishingHouse(this.publishingHouse);
        book.setPublicationYear(this.publicationYear);
        book.setSynopsis(this.synopsis);
        book.setStatus("N");
    }
    
    public void populateFields(Book book) throws ParseException {
        title = book.getTitle();
        author = book.getAuthor();
        publishingHouse = book.getPublishingHouse();
        publicationYear = book.getPublicationYear();
        genre = book.getGenre();
        synopsis = book.getSynopsis();
    }

    public void delete() throws Exception {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.id = Integer.parseInt(params.get("bookId"));
        Book book = bookDao.getById(id);
        book.setStatus("D");
        bookDao.update(book);
    }

    //Fix this
    public void lookup() throws ParseException{
        Book found = bookDao.getById(id);
        populateFields(found);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
