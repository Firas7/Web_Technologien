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
@Named("registerController")
@RequestScoped


public class RegisterController implements Serializable{
    
    public RegisterController(){
    }
    
    public String  register(String username, String password) throws SQLException, ClassNotFoundException{
        User user = UserFactory.findUserBysuername(username);
      
        if(user == null){
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.insert();
            return "login";
        }else{
            return "register";
        }
        
        
    }
}
