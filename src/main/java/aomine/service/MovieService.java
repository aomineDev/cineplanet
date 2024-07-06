package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.Movie;

public class MovieService {
  private ArrayList<Movie> movieList;
  
  public MovieService () {
    movieList = CineplanetDB.getInstance().getMovieList();
  }

  public ArrayList<Movie> getAll () {
    ArrayList<Movie> movieListCloned = new ArrayList<>(movieList); 
    return movieListCloned;
  }

  // obtener 1 sola pelicula (movie id)

  public void create (String name, String cover) {
    movieList.add(new Movie(name, cover));
  }

  // actualizar pelicula

  // eliminar pelicula

}
