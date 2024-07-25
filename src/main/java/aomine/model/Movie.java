package aomine.model;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Movie {
  private String title;
  private String cover;
  private ArrayList<Show> showList;
  private String gender;
  private String category;
  private boolean isInPremiere;
  private LocalTime duration;

  public Movie(String title, String cover, ArrayList<Show> showList, String gender, String category, boolean isInPremiere, LocalTime duration) {
    this.title = title;
    this.cover = cover;
    this.showList = new ArrayList<>(showList);
    this.gender = gender;
    this.category = category;
    this.isInPremiere = isInPremiere;
    this.duration = duration;
  }

  public Movie(String title, String cover) {
    this.title = title;
    this.cover = cover;
  }

  public String getTitle() {
    return this.title;
  }

  public String getCover() {
    return this.cover;
  }

  public ArrayList<Show> getShowList() {
    return this.showList;
  }

  public String getGender() {
    return this.gender;
  }

  public String getCategory() {
    return this.category;
  }

  public boolean getIsInPremiere() {
    return this.isInPremiere;
  }

  public LocalTime getDuration() {
    return this.duration;
  }

  public String getFormattedDuration() {
    String pattern = "h'h' mm'min'";
    DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

    return this.duration.format(format);
  }
  
  public String getFormattedTicketPrice(double ticketPrice) {
    DecimalFormat df = new DecimalFormat("#.00");

    return "S/. " + df.format(ticketPrice);
  }
}
