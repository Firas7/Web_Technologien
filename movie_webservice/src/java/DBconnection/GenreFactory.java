/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;

import Entity.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firas
 */
public class GenreFactory {
    
    public static Genre findGenreById(long id) throws ClassNotFoundException{
    
        Connection conn = null;
        PreparedStatement stat = null ;
        ResultSet result = null;
        Genre genre = null;
        String sql = "select * from genre where genreID = ? ";
        
        try{
            conn = DBConnector.getConnector();
            stat = conn.prepareStatement(sql);
            stat.setLong(1, id);
            result = stat.executeQuery();
            
            if(result.next()){
                genre = new Genre();
                genre.setGenreId(result.getLong("genreID"));
                genre.setGenre(result.getString("genre"));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return genre;
    }
    
    public static Genre findGenreByName(String genreName) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stat = null ;
        ResultSet result = null;
        Genre genre = null;
       
       
        
        try{
            conn = DBConnector.getConnector();
            String sql = "select * from genre where genre = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1, genreName);
            result = stat.executeQuery();
            
            while(result.next()){
                
                genre = new Genre();
                genre.setGenreId(result.getLong("genreID"));
                genre.setGenre(result.getString("genre"));
                System.out.println("*************"+ genre.getGenreId());
                System.out.println("*************"+genre.getGenre());
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return genre;
    }
}
