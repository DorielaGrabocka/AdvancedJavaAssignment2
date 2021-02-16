/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.BookDAO;
import DAO.ReviewDAO;
import DAO.UserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import models.Book;
import models.Review;
import models.ReviewPK;
import models.User;

/**
 *
 * @author Oli 
 */
@ManagedBean(name="bookDetailsBean")
@ViewScoped
public class BookDetailsBean {
    
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    
    private int bookID;
    private Book book;
    private BookDAO bookDao = new BookDAO();
    private ReviewDAO reviewDao = new ReviewDAO();
    private UserDAO userDao = new UserDAO();
    private double averageRating;
    private ReviewPK reviewId;
    private String outputText = "";
    
    public BookDetailsBean(){
        
    }
    
    public void init(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.bookID = Integer.parseInt(params.get("bookID"));
        book = bookDao.getById(bookID);
        averageRating = bookDao.getAverageRating(bookID);
    }
    
    public List<Review> getReviews(){
       return reviewDao.getBookReviews(bookID);
    }
    
    public String getFullName(int userId){
        User user = userDao.getById(userId);
        return user.getName() + " " + user.getSurname();
    }
    
    public void removeReview(int userID, int bookID) throws Exception{
        Review review = reviewDao.getByIds(userID, bookID);
        reviewDao.delete(review);
        outputText="Review successfully removed!";
        FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("bookDetails.xhtml");
    }
    
    public void addReview(){
        
    }

    public User getCurrentUser() {
        return loginBean.getUser();
    }
    
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookId) {
        this.bookID = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageReview) {
        this.averageRating = averageReview;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }
}
