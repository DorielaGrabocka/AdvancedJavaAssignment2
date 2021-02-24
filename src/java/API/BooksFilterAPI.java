/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DAO.BookDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Book;

/**
 *
 * @author Doriela
 */
@WebService(serviceName = "BooksFilterAPI")
public class BooksFilterAPI {

     @WebMethod(operationName = "filterBooks")
    public List<Book> filterBooks(@WebParam(name="title")String title,
            @WebParam(name="author") String author,
            @WebParam(name="genre")String genre,
            @WebParam(name="minAverageRating")int minAverageRating, 
            @WebParam(name="maxAverageRating")int maxAverageRating)
    {
        BookDAO bookDAO = new BookDAO();
        if(minAverageRating==0 && maxAverageRating==0 && !bookDAO.isValueSet(title) && !bookDAO.isValueSet(author)
                && !bookDAO.isValueSet(genre))//nothing is selected
            return null;
        
        return bookDAO.filterBooks(title, author, maxAverageRating, 
                maxAverageRating, genre);
    }
}
