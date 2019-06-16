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
                movie.setRegisseur(result.getInt("regisseur"));
                movie.setStars(result.getInt("sterne"));
                
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
     String sql = "select movie.movieID, movie.movieTitle, movie.year, movie.regisseur, movie.sterne from usermovie inner join user on usermovie.username = user.username \n" +
                  "inner join movie on usermovie.`movieID` = movie.`movieID` where user.username = ?";
     
     try{
         conn = DBConnector.getConnector();
         stat = conn.prepareStatement(sql);
         stat.setString(1, username);
         result = stat.executeQuery();
         while(result.next()){
             movie = new Movie();
             movie.setId(result.getLong("movieID"));
             movie.setTitle(result.getString("movieTitle"));
             movie.setYear(result.getInt("year"));
             movie.setRegisseur(result.getInt("Regisseur"));
             movie.setStars(result.getInt("sterne"));
             movies.add(movie);
         }
     }catch(SQLException ex){
         ex.printStackTrace();
     }
     return movies;
    }
    
    public static List<Movie> findMoviesByTitle(String title) throws ClassNotFoundException{
      
     List<Movie> movies = new ArrayList<Movie>();
     Connection conn = null;
     PreparedStatement stat = null;
     ResultSet result = null;
     Movie movie = null;
     String sql = "select movieID, movieTitle, year, regisseur from movie where upper(movieTitle) like upper(?)";
     
     try{
         conn = DBConnector.getConnector();
         stat = conn.prepareStatement(sql);
         stat.setString(1, title);
         result = stat.executeQuery();
         while(result.next()){
             movie = new Movie();
             movie.setId(result.getLong("movieID"));
             movie.setTitle(result.getString("movieTitle"));
             movie.setYear(result.getInt("year"));
             movie.setRegisseur(result.getInt("Regisseur"));
             movies.add(movie);
         }
     }catch(SQLException ex){
         ex.printStackTrace();
     }
     return movies;
    }
    
    public static List<Movie> findByRegisseur(String regisseur) throws ClassNotFoundException{
        
           List<Movie> movies = new ArrayList<Movie>();
            Connection conn = null;
            PreparedStatement stat = null;
            ResultSet result = null;
            Movie movie = null;
            String sql = "select movie.movieID, movie.movieTitle, movie.year, movie.sterne from movie inner join person on movie.regisseur = person.personID where upper(person.name) like upper(?)";
    
        try{
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            stat.setString(1, regisseur);
            result = stat.executeQuery();
            while(result.next()){
                movie = new Movie();
                movie.setId(result.getLong("movieID"));
                movie.setTitle(result.getString("movieTitle"));
                movie.setYear(result.getInt("year"));
                movie.setStars(result.getInt("sterne"));
                movies.add(movie);
        }
        }catch(SQLException ex){
         ex.printStackTrace();
        }
            
        return movies;
        
    }
      
}
