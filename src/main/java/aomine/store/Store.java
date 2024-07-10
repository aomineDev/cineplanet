package aomine.store;

import java.time.LocalDate;
import java.util.ArrayList;

import aomine.model.Movie;
import aomine.model.ShowTime;
import aomine.model.User;

public class Store {
  private static Store instance;
  private User user;
  private Movie movie;
  private String format;
  private LocalDate date;
  private ShowTime showTime;
  private ArrayList<String> selectedSeats;

  private Store() {}

  public static Store getInstance() {
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

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public ShowTime getShowTime() {
    return showTime;
  }

  public void setShowTime(ShowTime showTime) {
    this.showTime = showTime;
  }

  public ArrayList<String> getSelectedSeats() {
    return selectedSeats;
  }

  public void setSelectedSeats(ArrayList<String> selectedSeats) {
    this.selectedSeats = selectedSeats;
  }
}
