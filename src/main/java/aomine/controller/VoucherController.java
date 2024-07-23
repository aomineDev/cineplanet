package aomine.controller;

import aomine.store.Store;

import java.util.ArrayList;

import aomine.model.Seat;
import aomine.service.SeatService;

public class VoucherController {
  private Store store;
  private SeatService seatService;
  private ArrayList<String> selectedSeats;

  public VoucherController() {
    store = Store.getInstance();
    seatService = new SeatService();
    selectedSeats = store.getSelectedSeats();
  }

  public String getStoreSelectedSeats() {
    return store.getSelectedSeatsToString();
  }

  public String getStoreMovieTitle() {
    return store.getMovie().getTitle();
  }

  public String getStoreDate() {
    return store.getDate();
  }

  public String getStoreTime() {
    return store.getShowTime().getFormattedTime();
  }

  public int getStoreRoomNumber() {
    return store.getRoomNumber();
  }

  public String getStoreFormat() {
    return store.getFormat();
  }

  public int getStoreQunatity() {
    return selectedSeats.size();
  }

  public String getStoreticketPrice() {
    double ticketPrice = store.getTicketPrice();
    return store.getMovie().getFormatedTicketPrice(ticketPrice);
  }

  public String getTotalPrice() {
    double totalPrice =  store.getTicketPrice() * getStoreQunatity();

    return store.getMovie().getFormatedTicketPrice(totalPrice);
  }

  public void setOccupiedSeats() {
    int seatId = store.getShowTime().getSeatId();
    Seat seat = seatService.getById(seatId);

    for (String seatPos: selectedSeats) {
      int rowIndex = store.getSelectedSeatRowIndex(seatPos);
      int columnIndex = store.getSelectedSeatColumnIndex(seatPos);
      
      seat.updateSeatsSelected(rowIndex, columnIndex);
    }

    selectedSeats.clear();
  }

  public void createVoucher() {

  }
}
