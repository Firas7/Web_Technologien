/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanController;

import DBConnect.Movie;
import DBConnect.MovieFactory;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Firas Sh
 */

@Named(value = "movieSucheController")
@RequestScoped

public class MovieSucheController {
    
    private  List<Movie> filmListe;
   
    public MovieSucheController(){
       
    }
    
    
    /*
    * loading the film
    */
    public void ladeFilme(String title){
       filmListe =   MovieFactory.findByAnyTitle(title);
    }
    /**
     *
     * @return
     */
    public List<Movie> getFilmListe(){
        return filmListe;
    }
}
