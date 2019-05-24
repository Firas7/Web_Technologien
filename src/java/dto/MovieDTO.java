/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import DBConnect.Movie;
import DBConnect.MovieFactory;
import DBConnect.Person;
import DBConnect.PersonFactory;
import java.util.List;

/**
 *
 * @author maxmustermann
 */
public class MovieDTO {
    private long id;
    private String title;
    private String regisseur;
    private int year;
    private char type;
    
    public MovieDTO(long id, String title, String regisseur, int year, char type) {
        this.id = id;
        this.title = title;
        this.regisseur = regisseur;
        this.year = year;
        this.type = type;
    }

    public MovieDTO() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the regisseur
     */
    public String getRegisseur() {
        return regisseur;
    }

    /**
     * @param regisseur the regisseur to set
     */
    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }
    
    public static void fillMovieDTOList(List<MovieDTO> movieDTOList, String username) {
        List<Movie> movieList = MovieFactory.findByUser(username);
        
        for (Movie m : movieList) {
            MovieDTO mDTO = new MovieDTO();
            mDTO.setId(m.getId());
            mDTO.setTitle(m.getTitle());
            mDTO.setType(m.getType());
            mDTO.setYear(m.getYear());
            
            Person p = PersonFactory.findById(m.getRegisseur());
            mDTO.setRegisseur(p.getName());
            
            movieDTOList.add(mDTO);
        }
    }
}
