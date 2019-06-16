/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;

import Entity.Genre;
import Entity.Movie;
import Entity.MovieCharacter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Firas
 */
public class MovieFactory {
       
    public static Movie findMovieByTitle(String title) throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        Movie movie= null;
        String sql = "select * from movie where movieTitle  = ?";
        try{
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            stat.setString(1, title);
            result = stat.executeQuery();
            if(result.next()){
                movie = new Movie();
                movie.setId(result.getLong("movieID"));
                movie.setTitle(title);
                movie.setYear(result.getInt("year"));
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return movie; 
    }
    
    
    public static ArrayList<Movie> findAllMovies() throws ClassNotFoundException{
        
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie = null;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        String sql = "select * from movie";
        
        try{
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            result = stat.executeQuery();
            while(result.next()){
                movie = new Movie();
                movie.setTitle(result.getString("movieTitle"));
                movie.setYear(result.getInt("year"));
                movies.add(movie);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return movies;
    }
    
    public static List<Movie> findByUser(String username) throws ClassNotFoundException, SQLException{
    
     ArrayList<Movie> movies = new ArrayList<Movie>();
     Connection conn = null;
     PreparedStatement stat = null;
     ResultSet result = null;
     Movie movie = null;
     String sql = "SELECT * from userMovie um join movie m on um.movieID = m.movieID join user u on um.username = u.unsername where username = ?";
     
     try{
         conn = DBConnector.getConnector();
         stat = conn.prepareStatement(sql);
         stat.setString(1, username);
         result = stat.executeQuery();
         while(result.next()){
             movie = new Movie();
             movie.setTitle(result.getString("title"));
             movie.setYear(result.getInt("year"));
             movies.add(movie);
         }
     }catch(SQLException ex){
         ex.printStackTrace();
     }
     return movies;
    }
    
    
    public static List<Movie> findMovieByStars(int stars) throws ClassNotFoundException, SQLException {
        
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        Movie movie = null;
        String sql = "SELECT * from movie where sterne = ?"; 
       
        try {
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            stat.setInt(5, stars);
            result = stat.executeQuery();
            while(result.next()){
                movie = new Movie();
                movie.setTitle(result.getString("title"));
                movie.setYear(result.getInt("year"));
                movies.add(movie);
            }
        }catch(SQLException ex) {
            ex.printStackTrace(); 
        }
        
        return movies; 
    }
    
}
