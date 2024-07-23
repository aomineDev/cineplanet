package aomine.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import aomine.App;
import aomine.controller.MovieController;
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
  private Text tTicketPrice;

  @FXML
  private Text tGenderDuration;

  @FXML
  private HBox hbFormatBox;

  @FXML
  private HBox hbShowDateBox;

  @FXML
  private HBox hbShowTimeBox;

  private MovieController movieController;
  private Movie movie;
  private ArrayList<Show> showList;
  private ArrayList<ShowDate> showDateList;
  private ArrayList<ShowTime> showTimeList;

  @FXML
  public void initialize() {
    movieController = new MovieController();
    movie = movieController.getStoreMovie();

    Image image = new Image(getClass().getResource("/aomine/images/movies/3x-" + movie.getCover()).toExternalForm());

    ivCover.setImage(image);

    tTitle.setText(movie.getTitle() + " - " + movie.getCategory());

    tGenderDuration.setText(movie.getGender() + " | " + movie.getFormattedDuration());

    // Show
    showList = movie.getShowList();

    renderFormatBtnList(showList);

    tTicketPrice.setText(movie.getFormatedTicketPrice(showList.get(0).getTicketPrice()));

    // show date
    showDateList = showList.get(0).getShowDateList();
    renderShowDateBtnList(showDateList);

    // Show time
    showTimeList = showDateList.get(0).getShowTimeList();

    renderShowTimeBtnList(showTimeList);
  }

  @FXML
  void handleGoBackBtnClick(ActionEvent event) throws IOException {
		App.setRoot("moviesView");
  }

  @FXML 
  void hadleContinueBtnClick(ActionEvent event) throws IOException {
    App.setRoot("seatView");
  }

  void handleFormatClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    Show show = (Show) button.getUserData();
    showDateList = show.getShowDateList();

    removeActiveClassOf(hbFormatBox);
    button.getStyleClass().add("active");

    tTicketPrice.setText(movie.getFormatedTicketPrice(show.getTicketPrice()));

    renderShowDateBtnList(showDateList);

    renderShowTimeBtnList(showDateList.get(0).getShowTimeList());

    movieController.setStoreFormat(show.getFormat());
    movieController.setStoreTicketPrice(show.getTicketPrice());
  }

  void handleShowDateClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    ShowDate showDate = (ShowDate) button.getUserData();

    removeActiveClassOf(hbShowDateBox);
    button.getStyleClass().add("active");

    renderShowTimeBtnList(showDate.getShowTimeList());

    movieController.setStoreDate(showDate.getFormattedDate());
  }

  void handleShowTimeClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    ShowTime showTime = (ShowTime) button.getUserData();

    removeActiveClassOf(hbShowTimeBox);
    button.getStyleClass().add("active");

    movieController.setStoreShowTime(showTime);
  }

  // Render buttons - methods
  void renderFormatBtnList(ArrayList<Show> showList) {
		for (Show show: showList) {
      Button button = new Button(show.getFormat());
      button.getStyleClass().add("btn-format");
      hbFormatBox.getChildren().add(button);

      button.setUserData(show);
      button.setOnAction(this::handleFormatClick);
    }
    
    setActiveClassTo(hbFormatBox);

    movieController.setStoreFormat(showList.get(0).getFormat());
    movieController.setStoreTicketPrice(showList.get(0).getTicketPrice());
  }

  void renderShowDateBtnList(ArrayList<ShowDate> showDateList) {
    hbShowDateBox.getChildren().clear();

    for (ShowDate showDate: showDateList) {
      Button button = new Button(showDate.getFormattedDate());
      button.getStyleClass().add("btn-date-time");

      button.setUserData(showDate);
      button.setOnAction(this::handleShowDateClick);

      hbShowDateBox.getChildren().add(button);
    }

    setActiveClassTo(hbShowDateBox);

    movieController.setStoreDate(showDateList.get(0).getFormattedDate());
  }

  void renderShowTimeBtnList(ArrayList<ShowTime> showTimeList) {
    hbShowTimeBox.getChildren().clear();

    for (ShowTime showTime: showTimeList) {
      Button button = new Button(showTime.getFormattedTime());
      button.getStyleClass().add("btn-date-time");

      button.setUserData(showTime);
      button.setOnAction(this::handleShowTimeClick);
      hbShowTimeBox.getChildren().add(button);
    }

    setActiveClassTo(hbShowTimeBox);

    movieController.setStoreShowTime(showTimeList.get(0));
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