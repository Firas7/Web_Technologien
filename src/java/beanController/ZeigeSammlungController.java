/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanController;

import dto.MovieDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author a05-0tg-u1
 */
@Named(value = "zeigeSammlungController")
@RequestScoped
public class ZeigeSammlungController {
    
    private final List<MovieDTO> movieDTOList;

    /**
     * Creates a new instance of ZeigeSammlungController
     */
    public ZeigeSammlungController() {
        movieDTOList = new ArrayList<MovieDTO>();
    }
    
    /**
     * @return the movieList
     */
    public List<MovieDTO> getMovieDTOList() {
        return movieDTOList;
    }
    
    public void ladeSammlung(String username) {
        MovieDTO.fillMovieDTOList(movieDTOList, username);
    }
}
