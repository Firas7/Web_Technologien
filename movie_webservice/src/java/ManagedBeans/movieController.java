/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.GenreFactory;
import DBconnection.MovieFactory;
import DBconnection.PersonFactory;
import Entity.Genre;
import Entity.Movie;
import Entity.MovieCharacter;
import Entity.MovieGenre;
import Entity.Person;
import Entity.UsernameMovies;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Scope;

/**
 *
 * @author Firas
 */
@ManagedBean
@Named("movieController")
@RequestScoped

public class movieController implements Serializable{
    
    public String addNewMovie(String title, int year, int regisseur, char type, List<String> genres, List<String> characters, int stars) throws ClassNotFoundException, SQLException{
       
        try{
                Movie movie = new Movie();
                movie.setTitle(title);
                movie.setYear(year);
                movie.setRegisseur(regisseur);
                movie.setType(type);
                movie.setStars(stars);
                movie.insert();
                movie = MovieFactory.findMovieByTitle(title);
                MovieGenre mg = new MovieGenre();
                
               
             for(int i = 0; i < genres.size(); i++){
                  
                    Genre genre = GenreFactory.findGenreById(Long.valueOf(genres.get(i)));
                    mg.setMovieId(movie.getId());
                    mg.setGenreId(genre.getGenreId());
                    mg.insert();
              }
               
                MovieCharacter mc = new MovieCharacter();
                for(int i = 0; i < characters.size();i++){
                    Person person = PersonFactory.findUserByPersonName(characters.get(i));
                    mc.setMovieID(movie.getId());
                    mc.setCharacter(characters.get(i));
                    mc.setPersonID(person.getId());
                    mc.insert();
                }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return "addToCollection";
    }
    
    public String addToMyCollection(String username, String movieTitle) throws ClassNotFoundException, SQLException{
        
        UsernameMovies usernamemovies = new UsernameMovies();
        Movie movie = MovieFactory.findMovieByTitle(movieTitle);
        usernamemovies.setMvoieID(movie.getId());
        usernamemovies.setUsername(username);
        System.out.println(username);
        System.out.println(movie.getId());
        usernamemovies.insert();
        return "success";
    }
}
