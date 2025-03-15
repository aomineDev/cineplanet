package aomine.controller;

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

  public void setStoreDate(String date) {
    store.setDate(date);
  }

  public void setStoreTicketPrice(double ticketPrice) {
    store.setTicketPrice(ticketPrice);
  }

  public void setStoreShowTime(ShowTime showTime) {
    store.setShowTime(showTime);
  }
}
