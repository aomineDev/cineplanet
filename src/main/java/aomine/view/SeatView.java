package aomine.view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import aomine.service.SeatService;
import aomine.controller.SeatController;
import aomine.model.Seat;

public class SeatView {
  @FXML
  private Text tRoomNumber;

  @FXML
  private Text tSelectedSeats;

  @FXML 
  private FlowPane fpSeatList;

  private ArrayList<String> selectedSeats;

  @FXML
  public void initialize() {
    SeatService seatService = new SeatService();
    selectedSeats = new ArrayList<>();
    SeatController seatController = new SeatController();

    Seat seat = seatService.get(1);
    String[][] seats = seat.getSeats();
    selectedSeats = new ArrayList<>();

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
        else if (seats[i][j].equals("O")) button.getStyleClass().add("seat-occupied");

        fpSeatList.getChildren().add(button);
      }
    }
  }

  void handleSeatBtnClick (ActionEvent event) {
    Button button = (Button) event.getSource();
    String seatIndex = (String) button.getUserData();

    if (button.getStyleClass().contains("seat-empty")) {
      button.getStyleClass().remove("seat-empty");
      button.getStyleClass().add("seat-selected");
      selectedSeats.add(seatIndex);
    } else {
      button.getStyleClass().remove("seat-selected");
      button.getStyleClass().add("seat-empty");
      selectedSeats.remove(selectedSeats.indexOf(seatIndex));
    }

    tSelectedSeats.setText(getSelectedSeatsToString());
  }

  String getSelectedSeatsToString() {
    String str = selectedSeats.toString();
    return str.substring(1, str.length() - 1);
  }
}
