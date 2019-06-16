/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DBconnection.MovieFactory;
import DBconnection.PersonFactory;
import Entity.Movie;
import Entity.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Firas
 */
public class MovieDTO {
    private long id;
    private String title;
    private int regisseur;
    private int year;
    private char type;

        
    public MovieDTO(){
        
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRegisseur(int regisseur) {
        this.regisseur = regisseur;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(char type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRegisseur() {
        return regisseur;
    }

    public int getYear() {
        return year;
    }

    public char getType() {
        return type;
    }

    
    public static void fillMovieDTOList(List<MovieDTO> moieDTOList, String username) throws ClassNotFoundException, SQLException{
        List<Movie> movieList = MovieFactory.findByUser(username);
        
        for (Movie m : movieList) {
            MovieDTO mDTO = new MovieDTO();
            mDTO.setId(m.getId());
            mDTO.setTitle(m.getTitle());
            mDTO.setType(m.getType());
            mDTO.setYear(m.getYear());
            mDTO.setRegisseur(m.getRegisseur());
            moieDTOList.add(mDTO);

        }
    }
   
}
