package aomine.db;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import aomine.model.User;
import aomine.model.Voucher;
import aomine.model.ShowTime;
import aomine.model.ShowDate;
import aomine.model.Show;
import aomine.model.Movie;
import aomine.model.Seat;

public class CineplanetDB {
  private static CineplanetDB instance;
  private ArrayList<User> userList;
  private ArrayList<Movie> movieList;
  private ArrayList<Show> showList;
  private ArrayList<ShowDate> showDateList;
  private ArrayList<ShowTime> showTimeList;
  private ArrayList<Seat> seatList;
  private ArrayList<Voucher> voucherList;

  private CineplanetDB () {
    userList  = new ArrayList<>();
    movieList = new ArrayList<>();
    showList = new ArrayList<>();
    showDateList = new ArrayList<>();
    showTimeList = new ArrayList<>();
    seatList = new ArrayList<>();
    voucherList = new ArrayList<>();
    
    // create user list
    fillUserList();

    // creat movie list
    fillMovieList();

    // create seat list
   fillSeatLIst();
  }

  public static CineplanetDB getInstance() {
    if (instance == null) instance = new CineplanetDB();
    return instance;
  }

  public ArrayList<User> getUserList() {
    return userList;
  }

  public ArrayList<Movie> getMovieList() {
    return movieList;
  }

  public ArrayList<Seat> getSeatList() {
    return seatList;
  }

  public ArrayList<Voucher> getVoucherList() {
    return voucherList;
  }

  private void fillUserList() {
    userList.add(new User("omar", "$2a$05$AYa5TjOGJLopZjnsQScX0ujx/6QJpgjnNyGUc7LYQfdAvzJQeH8sC"));
    userList.add(new User("jhordan", "$2a$05$AYa5TjOGJLopZjnsQScX0ujx/6QJpgjnNyGUc7LYQfdAvzJQeH8sC"));
  }

  private void fillMovieList() {
    // created show time list for date 1 - 2d
    showTimeList.add(new ShowTime(LocalTime.of(13, 0), 1)); 
    showTimeList.add(new ShowTime(LocalTime.of(17, 0), 2));
    showTimeList.add(new ShowTime(LocalTime.of(20, 0), 3));

    // create show date 1 for show 2d
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 25), showTimeList));

    // created show time list for date 2 - 2d
    showTimeList.clear();
    showTimeList.add(new ShowTime(LocalTime.of(17, 30), 4));
    showTimeList.add(new ShowTime(LocalTime.of(20, 30), 5));

    // create show date list 2 for show 2d
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 26), showTimeList));

    // create 2d show
    showList.add(new Show("2D", showDateList, 13.00));

    // create 3d show time list 1
    showTimeList.clear();
    showTimeList.add(new ShowTime(LocalTime.of(20, 0), 6));

    // create 3d show date list 1
    showDateList.clear();
    showDateList.add(new ShowDate(LocalDate.of(2024, 6, 25), showTimeList));

    // create 3d show
    showList.add(new Show("3D", showDateList, 16.00));

    // create movie list
    movieList.add(new Movie("The Cover", "cover.png", showList, "Musical", "7+" ,false, LocalTime.of(1, 23)));
    movieList.add(new Movie("Bad Boys", "bad-boys.png", showList, "Acción", "16+", false, LocalTime.of(2, 4)));
    movieList.add(new Movie("John Wick", "john-wick.png", showList, "Acción", "16+", false, LocalTime.of(1, 41)));
  }

  private void fillSeatLIst() {
    seatList.add(new Seat(1, 1));
    seatList.add(new Seat(2, 1));
    seatList.add(new Seat(3, 3));
    seatList.add(new Seat(4, 2));
    seatList.add(new Seat(5, 5));
    seatList.add(new Seat(6, 4));
  }
}
