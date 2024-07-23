package aomine.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowTime {
  private LocalTime time;
  private int seatId;

  public ShowTime (LocalTime time, int seatId) {
    this.time = time;
    this.seatId = seatId;
  }

  public LocalTime getTime() {
    return time;
  }

  public int getSeatId() {
    return seatId;
  }

  public String getFormattedTime() {
    String pattern = "h:mm a";
    DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

    return this.time.format(format);
  }
}
