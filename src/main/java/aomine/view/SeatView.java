package aomine.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import aomine.service.SeatService;
import aomine.store.Store;
import aomine.model.Seat;

public class SeatView {
  @FXML
  private Text tRoomNumber;

  @FXML
  private FlowPane fpSeatList;

  public void initialize() {
    int seatId = Store.getInstace().getSeatId();
    SeatService seatService = new SeatService();
    Seat seat = seatService.get(seatId);
    String[][] seats = seat.getSeats();
    
    for (int i = 0; i < seats.length; i++) {
      for (int j = 0; j < seats[i].length; j++) {
        Button button = new Button(i + "" + j);
        fpSeatList.getChildren().add(button);
      }
    }
  }
}
