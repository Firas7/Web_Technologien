/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import DTO.MovieDTO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Firas
 */
@ManagedBean
@Named("collectionController")
@RequestScoped

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
    
    
     
    
}
