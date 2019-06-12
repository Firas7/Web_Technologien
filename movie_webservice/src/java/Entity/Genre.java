/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class Genre {
    
    private long genreId;
    private String genre;

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }
    
    public Genre(){
    
    }
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
