/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Doriela
 */
@ManagedBean
@SessionScoped
public class BufferSessionBean {

    private int bookIDFromIndexToDetails;

    public BufferSessionBean() {
    }

    public int getBookIDFromIndexToDetails() {
        return bookIDFromIndexToDetails;
    }

    /**Method used to save the id of the book that the user has clicked.
     * The is is passed as a parameter from the frontend.
     * @return a string that will have redirect us to the bookDetails page.
     */
    public String saveBookIDFromIndexToDetails() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap();

        setBookIDFromIndexToDetails(Integer.parseInt(params.get("bookID")));
        return "bookDetails.xhtml?faces-redirect=true";
    }

    public void setBookIDFromIndexToDetails(int bookIDFromIndexToDetails) {
        this.bookIDFromIndexToDetails = bookIDFromIndexToDetails;
    }
}
