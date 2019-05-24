package beanController;

import DBConnect.Movie;
import DBConnect.Genre;
import DBConnect.GenreFactory;
import DBConnect.MovieCharacter;
import DBConnect.MovieGenre;
import DBConnect.Person;
import DBConnect.PersonFactory;
import DBConnect.UserMovie;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.*;

@Named(value = "movieController")
@RequestScoped
public class MovieController {
    
    public MovieController(){}
    
    public void anlegenFilm(String title, int regisseur, int erscheinungsjahr, 
            List<String> genres, List<String> schauspieler){
        Movie m=new Movie();
        MovieGenre mg=new MovieGenre();
        MovieCharacter mc=new MovieCharacter();
        
        m.setTitle(title);
        m.setRegisseur(regisseur);
        m.setYear(erscheinungsjahr);
        m.insert();
        
        for(int i=0; i<genres.size();i++){
            String genreStr = genres.get(i);
            List<Genre> genreList = GenreFactory.findByGenre(genreStr);
            mg.setMovieId(m.getId());
            mg.setGenreId(genreList.get(0).getId());
            mg.insert();    
        }
        
        for(int i=0; i<schauspieler.size();i++){
            String schauspielerStr = schauspieler.get(i);
            List<Person> personList = PersonFactory.findByName(schauspielerStr);
            mc.setMovieId(m.getId());
            mc.setPlayerId(personList.get(0).getId());
            mc.insert();    
        }
    }
    
    public void filmZurSammlung(String username, long movieID) {
        UserMovie um = new UserMovie();
        um.setUserName(username);
        um.setMovieID(movieID);
        um.insert();
    }
}
