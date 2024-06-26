package aomine.service;

import java.util.ArrayList;

import aomine.db.CineplanetDB;
import aomine.model.Seat;

public class SeatService {
  private ArrayList<Seat> seatList;

  public SeatService() {
    seatList = CineplanetDB.getInstance().getSeatList();
  }

  public ArrayList<Seat> getAll() {
    ArrayList<Seat> seatListCloned =new ArrayList<>(seatList);
    return seatListCloned;
  }
}
