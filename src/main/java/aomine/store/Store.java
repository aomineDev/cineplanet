package aomine.store;

import java.util.ArrayList;
import java.util.HashMap;

import aomine.model.Movie;
import aomine.model.ShowTime;
import aomine.model.User;
import aomine.model.Seat;

public class Store {
  private static Store instance;
  private User user;
  private Movie movie;
  private String format;
  private String date;
  private ShowTime showTime;
  private double ticketPrice;
  private Seat seat;
  private ArrayList<String> selectedSeats;
  private HashMap<Character, Integer> rowMapReverse;


  private Store() {
    selectedSeats = new ArrayList<>();
    rowMapReverse = new HashMap<>();

    rowMapReverse.put('A', 0);
    rowMapReverse.put('B', 1);
    rowMapReverse.put('C', 2);
    rowMapReverse.put('D', 3);
    rowMapReverse.put('E', 4);
    rowMapReverse.put('F', 5);
    rowMapReverse.put('G', 6);
    rowMapReverse.put('H', 7);
  }

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

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public ShowTime getShowTime() {
    return showTime;
  }

  public void setShowTime(ShowTime showTime) {
    this.showTime = showTime;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }

  public ArrayList<String> getSelectedSeats() {
    return selectedSeats;
  }

  public void setSelectedSeats(ArrayList<String> selectedSeats) {
    this.selectedSeats = selectedSeats;
  }

  public String getSelectedSeatsToString() {
    String str = selectedSeats.toString();

    return str.substring(1, str.length() - 1);
  }

  public int getSelectedSeatRowIndex(String seatPos) {
    return rowMapReverse.get(seatPos.charAt(0));
  }

  public int getSelectedSeatColumnIndex(String seatPos) {
    return Integer.parseInt(seatPos.substring(1)) - 1;
  }
}
