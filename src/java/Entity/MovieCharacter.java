/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Firas
 */
public class MovieCharacter {
    
    private Movie movie;
    private Person person;
    private String character;

    public MovieCharacter(Movie movie, Person person, String character) {
        this.movie = movie;
        this.person = person;
        this.character = character;
    }
  
    public Movie getMovie() {
        return movie;
    }

    public Person getPerson() {
        return person;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
}
