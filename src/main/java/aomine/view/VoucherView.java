package aomine.view;

import java.io.IOException;

import aomine.App;
import aomine.controller.VoucherController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class VoucherView {
  @FXML
  private Text tTicketPrice;

  @FXML
  private Text tClient;

  @FXML
  private Text tDate;

  @FXML
  private Text tQuantity;

  @FXML
  private Text tRoomNumber;

  @FXML
  private Text tSelectedSeats;

  @FXML
  private Text tTime;

  @FXML
  private Text tTitle;

  @FXML
  private Text tFormat;

  @FXML
  private Text tTotalPrice;

  @FXML
  private TextField tfClient;

  private VoucherController voucherController;

  @FXML
  public void initialize() {
    voucherController = new VoucherController();
    
    tTitle.setText(voucherController.getStoreMovieTitle());
    tDate.setText(voucherController.getStoreDate());
    tTime.setText(voucherController.getStoreTime());
    tRoomNumber.setText("sala " + voucherController.getStoreRoomNumber());
    tSelectedSeats.setText(voucherController.getStoreSelectedSeats() + "");
    tFormat.setText(voucherController.getStoreFormat() + " General");
    tQuantity.setText(voucherController.getStoreQunatity() + "");
    tTicketPrice.setText(voucherController.getStoreticketPrice());
    tTotalPrice.setText(voucherController.getTotalPrice());
  }

  @FXML
  void handleGoBackBtnClick(ActionEvent event) throws IOException {
    App.setRoot("seatView");
  }

  @FXML
  void handleFinishClick(ActionEvent event) throws IOException {
    voucherController.setOccupiedSeats();
    voucherController.createVoucher();
    voucherController.saveAsPng(App.getRoot().lookup("#vbVoucher"), "voucher");
    voucherController.saveAsPdf(App.getRoot().lookup("#vbVoucher"), "voucher");
    
    App.setRoot("moviesView");
  }

  @FXML
  void handleClientTyped(KeyEvent event) {
    tClient.setText(tfClient.getText());
  }
}
