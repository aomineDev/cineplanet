package aomine.model;

import java.util.ArrayList;

public class Show {
  private String format;
  private ArrayList<ShowDate> showDateList;

  public Show (String format, ArrayList<ShowDate> showDateList) {
    this.format = format;
    this.showDateList = showDateList;
  }

  public String getFormat() {
    return format;
  }

  public ArrayList<ShowDate> getShowDateList() {
    return showDateList;
  }
}
