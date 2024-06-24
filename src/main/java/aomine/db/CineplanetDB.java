package aomine.db;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import aomine.model.User;
import aomine.model.ShowTime;
import aomine.model.ShowDate;
import aomine.model.Show;
import aomine.model.Movie;

public class CineplanetDB {
  private static CineplanetDB instance;
  private ArrayList<User> users;
  private ArrayList<Movie> movies;

  private CineplanetDB () {
    users = new ArrayList<>();
    movies = new ArrayList<>();
    
    // create users
    users.add(new User("omar", "$2a$05$AYa5TjOGJLopZjnsQScX0ujx/6QJpgjnNyGUc7LYQfdAvzJQeH8sC"));
    users.add(new User("jhordan", "$2a$05$AYa5TjOGJLopZjnsQScX0ujx/6QJpgjnNyGUc7LYQfdAvzJQeH8sC"));

    // create show variables
    ArrayList<ShowTime> showTimeList = new ArrayList<>();;
    ArrayList<ShowDate> showDateList = new ArrayList<>();;
    ArrayList<Show> showList = new ArrayList<>();;
    
    // create 2d show time list 1
    showTimeList.add(new ShowTime(LocalTime.of(13, 0), 1));
    showTimeList.add(new ShowTime(LocalTime.of(17, 0), 1));
    showTimeList.add(new ShowTime(LocalTime.of(20, 0), 1));

    // create 2d show date list 1
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 25), (ArrayList<ShowTime>) showTimeList.clone()));

    // create 2d show time list 2
    showTimeList.clear();
    showTimeList.add(new ShowTime(LocalTime.of(17, 30), 3));
    showTimeList.add(new ShowTime(LocalTime.of(20, 30), 2));

    // create 2d show date list 2
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 26), (ArrayList<ShowTime>) showTimeList.clone()));

    // create 2d show
    showList.add(new Show("2d", (ArrayList<ShowDate>) showDateList.clone()));

    // create 3d show time list 1
    showTimeList.clear();
    showTimeList.add(new ShowTime(LocalTime.of(18, 0), 8));

    // create 3d show date list 1
    showDateList.clear();
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 30), (ArrayList<ShowTime>) showTimeList.clone()));

    // create 3d show
    showList.add(new Show("3d", (ArrayList<ShowDate>) showDateList.clone()));

    // create movies
    movies.add(new Movie("Cover", "cover.png", showList));
    movies.add(new Movie("Bad Boys", "bad-boys.png", showList));
    movies.add(new Movie("Mystery", "mystery.png", showList));
  }

  public static CineplanetDB getInstance() {
    if (instance == null) instance = new CineplanetDB();
    return instance;
  }

  public ArrayList<User> getUsers () {
    return users;
  }

  public ArrayList<Movie> getMovies() {
    return movies;
  }
}
