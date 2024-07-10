package aomine.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import aomine.App;
import aomine.controller.SeatController;
import aomine.model.Seat;

public class SeatView {
  @FXML
  private Text tRoomNumber;

  @FXML
  private TextField tfSelectedSeat;

  @FXML 
  private FlowPane fpSeatList;

  private SeatController seatController;

  @FXML
  public void initialize() {
    seatController = new SeatController();

    int seatId = seatController.getStoreSeatId();
    Seat seat = seatController.getSeatById(seatId);

    String[][] seats = seat.getSeats();

    tRoomNumber.setText("Sala N°: " + seat.getRoomNumber());
    
    for (int i = 0; i < seats.length; i++) {
      for (int j = 0; j < seats[i].length; j++) {
        Button button = new Button("");
        button.getStyleClass().add("seat");

        if (seats[i][j].equals("V")) button.getStyleClass().add("seat-void");
        else if (seats[i][j].equals("E")) {
          button.getStyleClass().add("seat-empty");
          button.setUserData(seatController.getRow(i) + "" + (j + 1));
          button.setOnAction(this::handleSeatBtnClick);
        }
        else if (seats[i][j].equals("S")) button.getStyleClass().add("seat-selected");
        else if (seats[i][j].equals("O")) button.getStyleClass().add("seat-occupied");

        fpSeatList.getChildren().add(button);
      }
    }
  }

  @FXML 
  void handleGoBackBtnClick (ActionEvent event) throws IOException {
    App.setRoot("movieView");
  }

  void handleSeatBtnClick (ActionEvent event) {
    Button button = (Button) event.getSource();
    String seatPos = (String) button.getUserData();

    if (button.getStyleClass().contains("seat-empty")) {
      button.getStyleClass().remove("seat-empty");
      button.getStyleClass().add("seat-selected");

      seatController.addStoreSelectedSeat(seatPos);
    } else {
      button.getStyleClass().remove("seat-selected");
      button.getStyleClass().add("seat-empty");
      
      seatController.removeStoreSelectedSeat(seatPos);
    }

    tfSelectedSeat.setText(getSelectedSeatsToString());
  }

  String getSelectedSeatsToString() {
    String str = seatController.getStoreSelectedSeats().toString();
    
    return str.substring(1, str.length() - 1);
  }
}
