package aomine.model;

import java.util.ArrayList;

public class Voucher {
  private String clientName;
  private String title;
  private String format;
  private String date;
  private String time;
  private ArrayList<String> selectedSeats;
  private double ticketPrice;
  private int roomNumber;

  public Voucher(String clientName, String title, String format, String date, String time,
      ArrayList<String> selectedSeats, double ticketPrice, int roomNumber) {
    this.clientName = clientName;
    this.title = title;
    this.format = format;
    this.date = date;
    this.time = time;
    this.selectedSeats = new ArrayList<>(selectedSeats);
    this.ticketPrice = ticketPrice;
    this.roomNumber = roomNumber;
  }

  public String getClientName() {
    return clientName;
  }

  public String getTitle() {
    return title;
  }

  public String getFormat() {
    return format;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public ArrayList<String> getSelectedSeats() {
    return selectedSeats;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}
