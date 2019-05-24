/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanController;

import DBConnect.Benutzer;
import DBConnect.UserFactory;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author maxmustermann
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public String login(String username, String password) {
        
        Benutzer user = UserFactory.findByUserName(username);
        
        if (user == null)
            return "login";
        else {
            System.out.println(user);
            if (username.equals(user.getUserName()) 
                    && password.equals(user.getPasswort())) {
                return "success";
            } else {
                return "failure";
            }
        }
    }
}