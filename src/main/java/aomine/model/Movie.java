package aomine.model;

import java.util.ArrayList;

public class Movie {
  private String title;
  private String cover;
  private ArrayList<Show> showList;

  public Movie(String title, String cover, ArrayList<Show> showList) {
    this.title = title;
    this.cover = cover;
    this.showList = showList;
  }

  public Movie(String title, String cover) {
    this.title = title;
    this.cover = cover;
  }

  public String getTitle() {
    return title;
  }

  public String getCover() {
    return cover;
  }

  public ArrayList<Show> getShowList() {
    return showList;
  }
}
