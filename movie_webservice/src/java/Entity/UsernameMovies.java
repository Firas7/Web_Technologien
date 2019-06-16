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

/**
 *
 * @author Firas
 */
public class UsernameMovies {
       
    private String username;
    private long mvoieID;
    

    public String getUsername() {
        return username;
    }

    public long getMvoieID() {
        return mvoieID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMvoieID(long mvoieID) {
        this.mvoieID = mvoieID;
    }
    
    public void insert() throws ClassNotFoundException{
    
        Connection conn = null;
        PreparedStatement stat = null;
        try{
            conn = DBConnector.getConnector();
            String sql = "insert into usermovie (username, movieID) values (?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1, username);
            stat.setLong(2, mvoieID);
            stat.executeUpdate();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
