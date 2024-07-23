package aomine.model;

import java.util.ArrayList;

public class Show {
  private String format;
  private ArrayList<ShowDate> showDateList;
  private double ticketPrice;

  public Show (String format, ArrayList<ShowDate> showDateList, double ticketPrice) {
    this.format = format;
    this.showDateList = new ArrayList<>(showDateList);
    this.ticketPrice = ticketPrice;
  }

  public String getFormat() {
    return format;
  }

  public ArrayList<ShowDate> getShowDateList() {
    return showDateList;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }
}
