/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.MovieFactory;
import DTO.MovieDTO;
import Entity.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Firas
 */

@ManagedBean
@Named("searchController")
@RequestScoped

public class searchController {
    
    private List<Movie> searchList ;
    private String serachInput;
    private String s;
    
    /*
    * @return  
    */
    public List<Movie> getMovies(){
        return searchList;
    }

    public String getSerachInput() {
        return serachInput;
    }

    public void setSerachInput(String serachInput) {
        this.serachInput = serachInput;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    
    /*
    * load movies by title
    */
    public String search(String input) throws SQLException, ClassNotFoundException{
       
        switch(s){
            case "1":  searchList = MovieFactory.findMoviesByTitle(input);
            break;
            case "2": searchList = MovieFactory.findByRegisseur(input);
            break;
        }
        
        return "";
    }
}
