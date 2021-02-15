/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.BookDAO;
import java.util.List;
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
}
