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
public class Genre {

    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }
    
    /* @returns genre */
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
