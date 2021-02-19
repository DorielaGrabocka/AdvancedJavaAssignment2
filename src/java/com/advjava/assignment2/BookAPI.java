/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advjava.assignment2;

import DAO.BookDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import models.Book;

/**
 *
 * @author Doriela
 */
@WebService(serviceName = "BookAPI")
public class BookAPI {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "filterBooks")
    public List<Book> filterBooks(@WebParam(name="title")String title, 
            @WebParam(name="author") String author,
            @WebParam(name="genre") String genre,
            @WebParam(name="averageMin") int averageMinRating,
            @WebParam(name="averageMax") int averageMaxRating)
    {
        
        BookDAO bookDAO = new BookDAO();
        List<Book> filteredBooks = bookDAO.getAll();
        
        if(averageMinRating!=0 && averageMaxRating!=0){
            filteredBooks = filteredBooks
                    .stream()
                    .filter(b-> bookDAO.getAverageRating(b.getId())>averageMinRating)
                    .filter(b-> bookDAO.getAverageRating(b.getId())<averageMaxRating)
                    .collect(Collectors.toList());           
        }
        else if(averageMinRating!=0){
            filteredBooks = filteredBooks
                    .stream()
                    .filter(b-> bookDAO.getAverageRating(b.getId())>averageMinRating)
                    .collect(Collectors.toList());
        }
        else if(averageMaxRating!=0){
            filteredBooks = filteredBooks
                    .stream()
                    .filter(b-> bookDAO.getAverageRating(b.getId())<averageMaxRating)
                    .collect(Collectors.toList());
        }
        
        
        
        
        return filteredBooks;
    }
}
