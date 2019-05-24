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
@Named(value = "registerController")
@RequestScoped
public class RegisterController {

    /**
     * Creates a new instance of RegisterController
     */
    public RegisterController() {
    }
    
    public String register(String username, String password) {
                
        // TODO: Meldung fuer "Benutzer bereits vorhanden" ausgeben
        
        Benutzer user = UserFactory.findByUserName(username);
        
        if (user == null) {
            user = new Benutzer();
            user.setUserName(username);
            user.setPasswort(password);
            user.insert();
            return "login";
        } else {
            return "register";
        }
    }    
}
