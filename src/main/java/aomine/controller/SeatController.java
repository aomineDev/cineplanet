package aomine.controller;

import java.util.HashMap;
import java.util.ArrayList;

import aomine.model.Seat;
import aomine.store.Store;
import aomine.service.SeatService;

public class SeatController {
  private Store store;
  private SeatService seatService;
  private ArrayList<String> selectedSeats;
  private HashMap<Integer, String> rowMap;
  
  public SeatController() {
    store = Store.getInstance();
    seatService = new SeatService();
    selectedSeats = store.getSelectedSeats();
    rowMap = new HashMap<>();
    
    rowMap.put(0, "A");
    rowMap.put(1, "B");
    rowMap.put(2, "C");
    rowMap.put(3, "D");
    rowMap.put(4, "E");
    rowMap.put(5, "F");
    rowMap.put(6, "G");
    rowMap.put(7, "H");
  }

  public String getSeatPos (int row, int column) {
    return rowMap.get(row) + "" + (column + 1);
  }

  public int getStoreSeatId() {
    return store.getShowTime().getSeatId();
  }

  public Seat getSeatById(int seatId) {
    return seatService.getById(seatId);
  }

  public Seat getSeat() {
    int seatId = getStoreSeatId();

    return getSeatById(seatId);
  }

  public ArrayList<String> getStoreSelectedSeats() {
    return selectedSeats;
  }

  public String getStoreSelectedSeatsToString() {
    return store.getSelectedSeatsToString();
  }

  public void addStoreSelectedSeat(String seatPos) {
    selectedSeats.add(seatPos);
  }
  
  public void removeStoreSelectedSeat(String seatPos) {
    int seatPosIndex = selectedSeats.indexOf(seatPos);

    selectedSeats.remove(seatPosIndex);
  }

  public void clearStoreSelectedSeat() {
    selectedSeats.clear();
  }

  public String[][] getClonedSeatMatrix(String[][] seatMatrix) {
    String[][] clonedSeatMatrix = new String[8][19]; 
    
    for(int i = 0; i < seatMatrix.length; i++) {
      for (int j = 0; j < seatMatrix[i].length; j++) {
        clonedSeatMatrix[i][j] = seatMatrix[i][j];
      }
    }

    return clonedSeatMatrix;
  }

  public void setSelectedSeatsToMatrix(String[][] seatMatrix){
    for (String seatPos: this.getStoreSelectedSeats()) {
      int row = store.getSelectedSeatRowIndex(seatPos);
      int column = store.getSelectedSeatColumnIndex(seatPos);

      seatMatrix[row][column] = "S";
    }
  }

  public void setSeat(Seat seat) {
    store.setSeat(seat);
  }
}
