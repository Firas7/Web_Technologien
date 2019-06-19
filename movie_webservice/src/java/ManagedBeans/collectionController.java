/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DBconnection.MovieFactory;
import DTO.MovieDTO;
import Entity.Movie;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Firas
 */
@ManagedBean
@Named("collectionController")
@ViewScoped

public class collectionController implements Serializable{
        
    private final List<MovieDTO> movieDTOList;

    public collectionController(){
        movieDTOList = new ArrayList<>();
    }
    public List<MovieDTO> getMovieDTOList() {
        return movieDTOList;
    }
    
    public void ladeCollection(String username) throws ClassNotFoundException, SQLException{
        MovieDTO.fillMovieDTOList(movieDTOList,username);
    }
    
    public void ladeMovieFromCollection(String title , String username) throws SQLException, ClassNotFoundException{
      MovieDTO.findMovieInCollection(movieDTOList,title,username);
    }
    
    public String deleteFromCollection(long id , String username) throws ClassNotFoundException, SQLException{
        System.out.println(id);
        System.out.println(username);
        MovieFactory.deleteByUser(id, username);
        ladeCollection(username);
        return "movieCollection";
    }
}
