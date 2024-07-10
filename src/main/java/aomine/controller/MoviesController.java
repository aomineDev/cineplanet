package aomine.controller;

import java.util.ArrayList;
import aomine.model.Movie;
import aomine.service.MovieService;
import aomine.store.Store;

public class MoviesController {
  private MovieService movieService;
  private Store store;

  public MoviesController() {
    movieService = new MovieService();
    store =  Store.getInstance();
  }

  public ArrayList<Movie> getAll() {
    return movieService.getAll();
  }

  public String getStoreUserame() {
    return store.getUser().getUsername();
  }

  public void setStoreMovie(Movie movie) {
    store.setMovie(movie);
  }
}
