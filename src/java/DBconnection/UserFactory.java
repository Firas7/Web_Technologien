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
        String sql = "select username, password from user where username = ? ";
        
        try{
            Connection conn = DBConnector.getConnector();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
           if(result.next()){
               user = new User();
               user.setUsername(username);
               user.setPassword(result.getString("password"));   
               conn.close();
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Hier Fehelr");
        }
        
        return user;
    }
    
    
}
