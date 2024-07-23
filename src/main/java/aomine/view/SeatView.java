package aomine.view;

import java.io.IOException;

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
    Seat seat = seatController.getSeat();

    String[][] seatMatrix = seatController.getClonedSeatMatrix(seat.getSeatMatrix());

    tRoomNumber.setText("Sala N°: " + seat.getRoomNumber());
    seatController.setRoomNumber(seat.getRoomNumber());

    seatController.setSelectedSeatsToMatrix(seatMatrix);
    
    for (int i = 0; i < seatMatrix.length; i++) {
      for (int j = 0; j < seatMatrix[i].length; j++) {
        Button button = new Button("");
        button.getStyleClass().add("seat");

        if (seatMatrix[i][j].equals("V")) button.getStyleClass().add("seat-void");
        else if (seatMatrix[i][j].equals("E")) {
          button.getStyleClass().add("seat-empty");
          button.setUserData(seatController.getSeatPos(i, j));
          button.setOnAction(this::handleSeatBtnClick);
        }
        else if (seatMatrix[i][j].equals("S")) {
          button.getStyleClass().add("seat-selected");
          button.setUserData(seatController.getSeatPos(i, j));
          button.setOnAction(this::handleSeatBtnClick);
        }
        else if (seatMatrix[i][j].equals("O")) button.getStyleClass().add("seat-occupied");

        fpSeatList.getChildren().add(button);
      }
    }

    tfSelectedSeat.setText(seatController.getStoreSelectedSeatsToString());
  }

  @FXML 
  void handleGoBackBtnClick (ActionEvent event) throws IOException {
    seatController.clearStoreSelectedSeat();
    App.setRoot("movieView");
  }

  @FXML
  void handleContinueBtnClick(ActionEvent event) throws IOException {
    if (seatController.getStoreSelectedSeats().size() > 0) App.setRoot("voucherView");
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

    tfSelectedSeat.setText(seatController.getStoreSelectedSeatsToString());
  }
}
