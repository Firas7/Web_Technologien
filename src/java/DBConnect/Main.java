package DBConnect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 29.11.2017.
 */
public class Main {
    public static void main(String[] args) throws java.lang.Exception{

        
        Movie mov = new Movie();
        //Genre gen = new Genre(1);

        //gen.setGenre("Horror");
        //gen.insert();
        
        mov.setTitle("MiniWini");
        mov.setRegisseur(1);
        mov.setType('H');
        mov.setYear(1999);
        mov.insert();

        //mov.setTitle("StarTrek");
        //mov.update();

        //gen.setGenre("Thriller");
        //gen.update();

        //System.out.println(mov.getTitle() + ", " + mov.getYear() + ", " + mov.getType());
        //System.out.println(mov.getTitle());

        //mov.setMovieID(22);
        //mov.delete();
        
        /*
        MovieFactory mf = new MovieFactory();

        Movie move = mf.findById(42);
        System.out.println(move.getTitle());

        List<Movie> movieList = mf.findByTitle("StarTrek");

        for(Movie movie : movieList) {

            System.out.println(movie.getMovieID() + ", " + movie.getTitle() + ", " + movie.getType()  + ", " + movie.getYear());
        }

        
        /*
        GenreManager gm = new GenreManager();

        List<String> al = new ArrayList();
        al = gm.getGenres();

        for(String genre : gm.getGenres() ){
            System.out.println(genre);
        }
        */
    }

}
