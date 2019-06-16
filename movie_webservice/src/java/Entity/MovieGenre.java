/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import DBconnection.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class MovieGenre {
    private long movieId;
    private long genreId;
    
    public MovieGenre(){
    
    }
    
    public long getMovieId() {
        return movieId;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }
    
    public void insert() throws ClassNotFoundException, SQLException{
         
        Connection conn = null;
        PreparedStatement  stat = null;
        try{
            conn = DBConnector.getConnector();
            String sql = "insert into moviehasgenre (movieID, genreID) values (?,?)";
            stat = conn.prepareStatement(sql);
            stat.setLong(1, getMovieId());
            stat.setLong(2, getGenreId());
            stat.executeUpdate();
        }catch(SQLException e){
            e.getSQLState();
        }finally {
            stat.close();
            conn.close();
        }
        
    }
    
    
    
}
