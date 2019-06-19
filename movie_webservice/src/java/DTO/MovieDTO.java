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
    private int stars;

        
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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    
    
    public static void fillMovieDTOList(List<MovieDTO> movieDTOList, String username) throws ClassNotFoundException, SQLException{
        List<Movie> movieList = MovieFactory.findByUser(username);
        
        for (Movie m : movieList) {
            MovieDTO mDTO = new MovieDTO();
            mDTO.setId(m.getId());
            mDTO.setTitle(m.getTitle());
            mDTO.setType(m.getType());
            mDTO.setYear(m.getYear());
            mDTO.setStars(m.getStars());
            mDTO.setRegisseur(m.getRegisseur());
            movieDTOList.add(mDTO);
            System.out.println(mDTO.getTitle());
        }
    }
    
    public static void findMovieInCollection(List<MovieDTO> movieDTOList, String title, String username) throws ClassNotFoundException, SQLException{
    
        List<Movie> movieList = MovieFactory.findByUser(username);
        for(int i = 0 ; i < movieList.size(); i++){
            if(movieList.get(i).getTitle().equalsIgnoreCase(title)){
                MovieDTO mDTO = new MovieDTO();
                mDTO.setId(movieList.get(i).getId());
                mDTO.setTitle(movieList.get(i).getTitle());
                mDTO.setType(movieList.get(i).getType());
                mDTO.setYear(movieList.get(i).getYear());
                mDTO.setStars(movieList.get(i).getStars());
                mDTO.setRegisseur(movieList.get(i).getRegisseur());
                movieDTOList.add(mDTO);
            }
    
        }
 
    }
   
}
