package Entity;

import DBconnection.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Firas
 */

@Named(value = "movie")
public class Movie {
    
    private long id;
    private String title;
    private int year;
    private char type;
    private int regisseur;
    private ArrayList<Genre> genre;
    private ArrayList<MovieCharacter> characters;
    private int stars; 

     public Movie(){
    
    }
     
    public Movie(String title, int year, char type, int regisseur, int stars) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.regisseur = regisseur;
        this.genre = new ArrayList<Genre>();
        this.stars = stars; 
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }

    public void setCharacters(ArrayList<MovieCharacter> characters) {
        this.characters = characters;
    }

    public long getId() {
        return id;
    }

    public ArrayList<MovieCharacter> getCharacters() {
        return characters;
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

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public char getType() {
        return type;
    }

    public int getRegisseur() {
        return regisseur;
    }
    
    public ArrayList<Genre> getGenre() {
        return genre;
    }
    
    public void setGenre(Genre genre){
        this.genre.add(genre);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
    
    
    
    public void insert() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement  stat = null;
        try{
            conn = DBConnector.getConnector();
            String sql = "insert into movie (movieTitle, year, type, regisseur , sterne) values (?,?,?,?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1, getTitle());
            stat.setInt(2, getYear());
            stat.setString(3, String.valueOf(getType()));
            stat.setInt(4, getRegisseur());
            stat.setInt(5, getStars()); 
            stat.executeUpdate();
            conn.close();
        }catch(SQLException e){
            e.getSQLState();
        }
    }

    @Override
    public String toString(){
        return this.id + ", "+this.title + ": " + this.year + ", " + this.type;
    }
}
