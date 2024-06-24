package aomine.controller;

import java.util.ArrayList;

import aomine.model.Movie;
import aomine.service.MovieService;

public class MoviesController {
  private MovieService movieService;

  public MoviesController() {
    movieService = new MovieService();
  }

  public ArrayList<Movie> getAll () {
    return movieService.getAll();
  }
}
