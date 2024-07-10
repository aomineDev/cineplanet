package aomine.controller;

import java.util.HashMap;
import java.util.ArrayList;

import aomine.model.Seat;
import aomine.store.Store;
import aomine.service.SeatService;

public class SeatController {
  private HashMap<Integer, String> rowMap;
  private Store store;
  private SeatService seatService;
  private ArrayList<String> selectedSeats;

  public SeatController() {
    rowMap = new HashMap<>();
    store = Store.getInstance();
    seatService = new SeatService();
    selectedSeats = store.getSelectedSeats();
    
    rowMap.put(0, "A");
    rowMap.put(1, "B");
    rowMap.put(2, "C");
    rowMap.put(3, "D");
    rowMap.put(4, "E");
    rowMap.put(5, "F");
    rowMap.put(6, "G");
    rowMap.put(7, "H");
  }

  public String getRow (Integer index) {
    return rowMap.get(index);
  }

  public int getStoreSeatId() {
    return store.getShowTime().getSeatId();
  }

  public Seat getSeatById(int seatId) {
    return seatService.getById(seatId);
  }

  public ArrayList<String> getStoreSelectedSeats() {
    return selectedSeats;
  }

  public void addStoreSelectedSeat(String seatPos) {
    selectedSeats.add(seatPos);
  }
  
  public void removeStoreSelectedSeat(String seatPos) {
    int seatPosIndex = selectedSeats.indexOf(seatPos);

    selectedSeats.remove(seatPosIndex);
  }
}
