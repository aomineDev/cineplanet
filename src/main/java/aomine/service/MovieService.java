package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.Movie;

public class MovieService {
  private ArrayList<Movie> movies;
  
  public MovieService () {
    movies = CineplanetDB.getInstance().getMovies();
  }

  public ArrayList<Movie> getAll () {
    ArrayList<Movie> clondedMovies = new ArrayList<>(movies); 
    return clondedMovies;
  }

  public void create (String name, String cover) {
    movies.add(new Movie(name, cover));
  }
}
