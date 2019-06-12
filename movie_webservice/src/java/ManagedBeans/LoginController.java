/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import DBconnection.UserFactory;
import Entity.User;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;



import javax.inject.Named;

/**
 *
 * @author Firas
 */
@ManagedBean
@Named("loginController")
@RequestScoped

public class LoginController implements Serializable{
    
    
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
 
    
    public String validate(String username, String password) throws SQLException, ClassNotFoundException{
        
        User user = UserFactory.findUserBysuername(username);
        if(user == null){
           return "login"; 
        }else{
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return "success";
               
            }else{
                return "failure";
            }
        } 
        
    }
   
}
