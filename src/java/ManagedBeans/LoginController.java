/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.DBConnector;
import DBconnection.UserFactory;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Firas
 */
@ManagedBean(value = "login")
@RequestScoped
public class LoginController {
    
    
    private String username;
    private String password;
    
    public LoginController(){
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
 
    
    public void validate(String username, String password) throws SQLException, ClassNotFoundException{
        
        User user = UserFactory.findUserBysuername(username);
        if(user == null){
            System.out.println("login nochmal"); 
        }else{
            System.out.println(user);
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                System.out.println("success"); 
               
            }else{
                
                System.out.println("Ohhhhh..."); 
            }
        }
        
    }
   
}
