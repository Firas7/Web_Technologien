/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entity.Genre;
import Entity.MovieCharacter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Firas
 */

@Named("movie")
@SessionScoped
public class Movie implements Serializable{
    
    private long id;
    private String title;
    
    private int year;
    private char type;
    private int regisseur;
    private ArrayList<String> genre;
    private ArrayList<String> characters;
    private int stars; 

    
     public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setRegisseur(int regisseur) {
        this.regisseur = regisseur;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }

    public char getType() {
        return type;
    }

    public int getRegisseur() {
        return regisseur;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    
    
    
}
