package aomine.store;

import aomine.model.Movie;
import aomine.model.User;

public class Store {
  private static Store instance;
  private User user;
  private Movie movie;
  private int seatId; 

  private Store() {}

  public static Store getInstace() {
    if (instance == null) instance = new Store();
    return instance;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public int getSeatId() {
    return seatId;
  }

  public void setSeatId(int seatId) {
    this.seatId = seatId;
  }
}
