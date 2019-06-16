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
    
    private List<Movie> moviesList ;
    
    /*
    * @return  
    */
    public List<Movie> getMovies(){
        return moviesList;
    }
    
    /*
    * load movies by title
    */
    public void searchMovie(String input) throws SQLException, ClassNotFoundException{
        moviesList = MovieFactory.findMoviesByTitle(input);
        
    }
    
    /*
    * load Movies by stars
    */
    public void searchMovieByStars(int stars) throws SQLException, ClassNotFoundException{
        moviesList = MovieFactory.findMoviesByStars(stars); 
    }
}
