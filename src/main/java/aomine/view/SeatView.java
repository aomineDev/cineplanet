package aomine.view;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
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
    tRoomNumber.setText(seat.getRoomNumber() + "");

    for (int i = 0; i < seats.length; i++) {
      for (int j = 0; j < seats[i].length; j++) {
        Button button = new Button("");
        button.getStyleClass().add("seat");

        if (seats[i][j].equals("V")) button.getStyleClass().add("seat-void");
        else if (seats[i][j].equals("E")) button.getStyleClass().add("seat-empty"); 
        else if (seats[i][j].equals("O")) button.getStyleClass().add("seat-occupied");

        fpSeatList.getChildren().add(button);
      }
    }
  }
}
