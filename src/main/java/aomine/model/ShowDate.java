package aomine.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ShowDate {
  private LocalDate date;
  private ArrayList<ShowTime> ShowTimeList;

  public ShowDate(LocalDate date, ArrayList<ShowTime> ShowTimeList) {
    this.date = date;
    this.ShowTimeList = new ArrayList<>(ShowTimeList);
  }

  public LocalDate getDate() {
    return date;
  }

  public ArrayList<ShowTime> getShowTimeList() {
    return ShowTimeList;
  }

  public String getFormattedDate() {
    String pattern = "dd/MM/yyyy";
    DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

    return this.date.format(format);
  }
}
