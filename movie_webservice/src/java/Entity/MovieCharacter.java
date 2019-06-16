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
public class MovieCharacter {
    
    private long id;
    private long movieID;
    private long personID;
    private String character;
    
    public MovieCharacter(){
    
    }
    public MovieCharacter(long movieid, long personid, String character) {
        this.movieID = movieid;
        this.personID = personid;
        this.character = character;
    }
  
    
    public long getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
    
    public long getMovieID() {
        return movieID;
    }

    public long getPersonID() {
        return personID;
    }

    public void setMovieID(long movieid) {
        this.movieID = movieid;
    }

    public void setPersonID(long personid) {
        this.personID = personid;
    }
    
    public void insert() throws ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement stat = null;
        String sql = "insert into movieCharacter (charact,movieID,personID) values (?,?,?) ";
        
        try{
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            stat.setString(1, getCharacter());
            stat.setLong(2,getMovieID());
            stat.setLong(3, getPersonID());
            stat.executeUpdate();
            conn.close();
            
        }catch(SQLException e){
            e.getSQLState();
        }
        
        
      
    }
}
