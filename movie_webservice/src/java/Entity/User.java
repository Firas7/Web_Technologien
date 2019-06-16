package Entity;

import DBconnection.DBConnector;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
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


public class User implements Serializable {
    
    private long id;
    private String username;
    private String password;

    public User(){
    
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override public String toString(){
        
        return "Username: " + this.getUsername() + "Password: " + this.getPassword();
    }
    
    public void insert() throws ClassNotFoundException, SQLException{
         Connection conn = null;
         PreparedStatement stat = null;
        try{
            
            conn = DBConnector.getConnector();            
            String sql = "insert into user (username,password) values (?,?)";
            stat = conn.prepareStatement(sql);
            stat.setString(1, getUsername());
            stat.setString(2, getPassword());
            stat.executeUpdate();
            conn.commit();
            
        }catch(SQLException e){
            e.getSQLState();
        }finally{
            stat.close();
            conn.close();
        }
    }
    
    
}
