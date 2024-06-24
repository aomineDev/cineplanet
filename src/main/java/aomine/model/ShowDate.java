package aomine.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShowDate {
  private LocalDate date;
  private ArrayList<ShowTime> ShowTimeList;

  public ShowDate(LocalDate date, ArrayList<ShowTime> ShowTimeList) {
    this.date = date;
    this.ShowTimeList = ShowTimeList;
  }

  public LocalDate getDate() {
    return date;
  }

  public ArrayList<ShowTime> getShowTimeList() {
    return ShowTimeList;
  }
}
