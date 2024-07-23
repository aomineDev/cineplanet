package aomine.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import aomine.App;
import aomine.controller.LoginController;
import aomine.model.User;
import aomine.utils.PasswordFieldSkin;

public class LoginView {

  @FXML
  private TextField tfUsername;

  @FXML
  private PasswordField pfPassword;

  @FXML 
  private SVGPath svgUsername;

  @FXML
  private SVGPath svgPassword;

  @FXML
  private Text tInvalidUsername;

  @FXML
  private Text tInvalidPassword;

  private LoginController loginController;

  @FXML
  public void initialize() {
    loginController = new LoginController();

    tfUsername.focusedProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue) svgUsername.getStyleClass().add("icon-fill-focused");
      else svgUsername.getStyleClass().remove("icon-fill-focused");
    });

    pfPassword.focusedProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue) svgPassword.getStyleClass().add("icon-stroke-focused");
      else svgPassword.getStyleClass().remove("icon-stroke-focused");
    });

    pfPassword.setSkin(new PasswordFieldSkin(pfPassword));
  }

  @FXML
  void handleLoginBtnClick(ActionEvent event) {
    try {
      String username = tfUsername.getText();
      String password = pfPassword.getText();

      User user = loginController.verifyUsername(username);

      boolean isPasswordVerified = loginController.verifyPassword(password, user);

      if (isPasswordVerified) {
        loginController.setStoreUser(user);
        App.setRoot("moviesView");
      }
    } catch (Exception e) {
      tfUsername.setText("");
      pfPassword.setText("");
      
      tInvalidUsername.setVisible(true);
      tInvalidPassword.setVisible(true);
    }
  }

  @FXML
  void handleUsernameTextChange(KeyEvent event) {
    if (tInvalidUsername.isVisible()) tInvalidUsername.setVisible(false);
  }

  @FXML
  void handlePasswordTextChange(KeyEvent event) {
    if (tInvalidPassword.isVisible()) tInvalidPassword.setVisible(false);
  }
}
