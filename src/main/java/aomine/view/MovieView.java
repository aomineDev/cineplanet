package aomine.view;

import java.io.IOException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import aomine.App;
import aomine.store.Store;
import aomine.model.Movie;
import aomine.model.Show;
import aomine.model.ShowDate;
import aomine.model.ShowTime;

public class MovieView {
	@FXML
  private ImageView ivCover;

  @FXML
  private Text tTitle;

  @FXML
  private HBox hbTypeBtnBox;

  @FXML
  private HBox hbShowDateBtnBox;

  @FXML
  private HBox hbShowTimeBtnBox;
  
  private Store store;
  private Movie movie;
  private ArrayList<Show> showList;
  private ArrayList<ShowDate> showDateList;
  private ArrayList<ShowTime> showTimeList;

  @FXML
  public void initialize() {
    store = Store.getInstace();
    movie = store.getMovie();

    Image image = new Image(getClass().getResource("/aomine/images/movies/3x-" + movie.getCover()).toExternalForm());

    ivCover.setImage(image);

    tTitle.setText(movie.getTitle());

    showList = movie.getShowList();

    renderFormatBtnList(showList);

    showDateList = showList.get(0).getShowDateList();

    renderShowDateBtnList(showDateList);

    showTimeList = showDateList.get(0).getShowTimeList();

    renderShowTimeBtnList(showTimeList);
  }

  @FXML
  void handleGoBackBtnClick(ActionEvent event) throws IOException {
		App.setRoot("moviesView");
  }

  void handleFormatBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    showDateList = (ArrayList<ShowDate>) button.getUserData();
    
    removeActiveClassOf(hbTypeBtnBox);

    button.getStyleClass().add("active");

    renderShowDateBtnList(showDateList);

    renderShowTimeBtnList(showDateList.get(0).getShowTimeList());
  }

  void handleShowDateBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    this.showTimeList = (ArrayList<ShowTime>) button.getUserData();

    removeActiveClassOf(hbShowDateBtnBox);

    button.getStyleClass().add("active");

    renderShowTimeBtnList(this.showTimeList);
  }

  void handleShowTimeBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    int seatId = (int) button.getUserData();

    removeActiveClassOf(hbShowTimeBtnBox);

    button.getStyleClass().add("active");

    store.setSeatId(seatId);
  }

  @FXML 
  void hadleContinueBtnClick(ActionEvent event) throws IOException {
    App.setRoot("seatView");
  }

  // Render buttons - methods
  void renderFormatBtnList(ArrayList<Show> showList) {
		for (Show show: showList) {
      Button button = new Button(show.getFormat());
      button.getStyleClass().add("btn-format");
      hbTypeBtnBox.getChildren().add(button);

      button.setUserData(show.getShowDateList());
      button.setOnAction(this::handleFormatBtnClick);
    }

    setActiveClassTo(hbTypeBtnBox);
  }

  void renderShowDateBtnList(ArrayList<ShowDate> showDateList) {
    hbShowDateBtnBox.getChildren().clear();

    for (ShowDate showDate: showDateList) {
      Button button = new Button(showDate.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
      button.getStyleClass().add("btn-date-time");


      button.setUserData(showDate.getShowTimeList());
      button.setOnAction(this::handleShowDateBtnClick);

      hbShowDateBtnBox.getChildren().add(button);
    }

    setActiveClassTo(hbShowDateBtnBox);
  }

  void renderShowTimeBtnList(ArrayList<ShowTime> showTimeList) {
    hbShowTimeBtnBox.getChildren().clear();

    for (ShowTime showTime: showTimeList) {
      Button button = new Button(showTime.getTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
      button.getStyleClass().add("btn-date-time");

      button.setUserData(showTime.getSeatId());
      button.setOnAction(this::handleShowTimeBtnClick);
      hbShowTimeBtnBox.getChildren().add(button);
    }

    store.setSeatId(showTimeList.get(0).getSeatId());
    setActiveClassTo(hbShowTimeBtnBox);
  }

  void removeActiveClassOf(HBox hbox) {
    hbox.getChildren().forEach(el -> {
      el.getStyleClass().remove("active");
    });
  }

  void setActiveClassTo(HBox hbox) {
    hbox.getChildren().get(0).getStyleClass().add("active");
  }
}