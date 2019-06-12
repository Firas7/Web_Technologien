/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.GenreFactory;
import DBconnection.MovieFactory;
import Entity.Genre;
import Entity.Movie;
import Entity.MovieCharacter;
import Entity.MovieGenre;
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
    
    int movieId; 
    int personId;
   
    
    public void addNewMovie(String title, int year, int regisseur, char type, List<String> genres) throws ClassNotFoundException, SQLException{
        Movie movie = new Movie();
        //MovieCharacter movieCharacters = new MovieCharacter();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setRegisseur(regisseur);
        movie.setType(type);
        movie.insert();
        
        movie = MovieFactory.findMovieByTitle(title);
       
        for(int i = 0; i < genres.size(); i++){
            MovieGenre mg = new MovieGenre();
            Long genreId = Long.valueOf(genres.get(i));
            System.out.println(genres.get(i));
            
            Genre genre = GenreFactory.findGenreById(genreId);
            mg.setMovieId(movie.getId());
            mg.setGenreId(genre.getGenreId());
            mg.insert();
        }
       
    }
    
    public int getMovieId() {
        return movieId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
}
