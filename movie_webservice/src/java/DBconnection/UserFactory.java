/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnection;

import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Firas
 */
/**
@reutrn user Objekt wenn vorhanden, wenn nich dann Null.
* */
public class UserFactory {
    
    public UserFactory(){
        
    }
    
    /*
     @para username */
    public static User findUserBysuername(String username) throws SQLException, ClassNotFoundException{
        
        User user = null;
        try{
            
            Connection conn = DBConnector.getConnector();
            String sql = "select * from user where username = '" + username + "' ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
           if(result.next()){
               
               user = new User();
               user.setUsername(result.getString("username"));
               user.setPassword(result.getString("password"));
               System.err.println(result.getString("username"));
               System.err.println(result.getString("username"));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return user;
    }
    
    public static ArrayList<User> findAllUser() throws SQLException, ClassNotFoundException{
        
        ArrayList<User> users = new ArrayList<User>();
        String sql = "select * from user ";
        try{
          
            Connection conn = DBConnector.getConnector();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            
            if(result.next()){
                for(User user : users){
                    user = new User();
                    user.setUsername(result.getString("username"));
                    user.setPassword(result.getString("password"));
                    users.add(user);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }
}
