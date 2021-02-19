package beans;

import DAO.BookDAO;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.Book;

/**
 *
 * @author Doriela
 */
@ManagedBean
@RequestScoped
public class IndexBean {
    
    private BookDAO bookDAO;
    private int rankTop;
    private int rankLast;
    
    //For searching
    private String searchTitle;
    private String searchAuthor;
    private String searchMax;
    private String searchMin;
    private String searchGenre;
    private String searchMessage;
    
    public IndexBean() {
        rankTop=0;
        rankLast=0;
        bookDAO = new BookDAO();
    }

    public List<Book> fillTopFive() {
        return bookDAO.getTopFive();
    }

    public List<Book> fillLastFive() {
        return bookDAO.getLastFive();
    }
    
    public String getAverageRating(int bookID){
        Double average = bookDAO.getAverageRating(bookID);
        if(average==0) return "NaN";
        return average.toString();
    }
    
    public int getRankTop(){
        return ++rankTop;
    }
    
    public int getRankLast(){
        return ++rankLast;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getSearchAuthor() {
        return searchAuthor;
    }

    public void setSearchAuthor(String searchAuthor) {
        this.searchAuthor = searchAuthor;
    }

    public String getSearchMax() {
        return searchMax;
    }

    public void setSearchMax(String searchMax) {
        this.searchMax = searchMax;
    }

    public String getSearchMin() {
        return searchMin;
    }

    public void setSearchMin(String searchMin) {
        this.searchMin = searchMin;
    }

    public String getSearchGenre() {
        return searchGenre;
    }

    public void setSearchGenre(String searchGenre) {
        this.searchGenre = searchGenre;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }
}
