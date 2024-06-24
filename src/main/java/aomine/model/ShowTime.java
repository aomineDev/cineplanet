package aomine.model;

import java.time.LocalTime;

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
}
