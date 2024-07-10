package aomine.controller;

import java.time.LocalDate;

import aomine.model.Movie;
import aomine.model.ShowTime;
import aomine.store.Store;

public class MovieController {
  public Store store;

  public MovieController() {
    this.store = Store.getInstance();
  }

  public Movie getStoreMovie() {
    return store.getMovie();
  }

  public void setStoreFormat(String format) {
    store.setFormat(format);
  }

  public void setStoreDate(LocalDate date) {
    store.setDate(date);
  }

  public void setStoreShowTime(ShowTime showTime) {
    store.setShowTime(showTime);
  }
}
