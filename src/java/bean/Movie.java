package bean;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.*;

@Named(value = "movie")
@RequestScoped
public class Movie {
    private long id;
    @ManagedProperty(value = "Avatar")
    @Size(min=0, max=20)
    private String title;
    private int regisseur;
    private List<String> schauspieler = new ArrayList<String>();
    @Min(1000)
    @Max(2018)
    private int erscheinungsjahr;
    private List<String> genres=new ArrayList<String>();
   
    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(int regisseur) {
        this.regisseur = regisseur;
    }

    public List<String> getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(List<String> schauspieler) {
        this.schauspieler = schauspieler;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public List getGenres() {
        return genres;
    }

    public void setGenres(List<String> genreList) {
        this.genres = genreList;
    }
    public List genreWahlen(){
        List<String> result=new ArrayList<String>();
    /**    
        if(CheckBox Action is Cecked)
        {
            result.add(genre.Action.toString());
        }
        
        if(CheckBox Adenture is Cecked)
        {
            result.add(genre.Adventure.toString());
        }
        */
        return result;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
}
