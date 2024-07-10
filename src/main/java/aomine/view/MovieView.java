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
  private HBox hbTypeBtnBox;

  @FXML
  private HBox hbShowDateBtnBox;

  @FXML
  private HBox hbShowTimeBtnBox;
  
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

  @FXML 
  void hadleContinueBtnClick(ActionEvent event) throws IOException {
    App.setRoot("seatView");
  }

  void handleFormatBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    Show show = (Show) button.getUserData();
    showDateList = show.getShowDateList();
    
    removeActiveClassOf(hbTypeBtnBox);

    button.getStyleClass().add("active");

    movieController.setStoreFormat(show.getFormat());

    renderShowDateBtnList(showDateList);

    renderShowTimeBtnList(showDateList.get(0).getShowTimeList());
  }

  void handleShowDateBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    ShowDate showDate = (ShowDate) button.getUserData();
    showTimeList = showDate.getShowTimeList();

    removeActiveClassOf(hbShowDateBtnBox);

    button.getStyleClass().add("active");

    movieController.setStoreDate(showDate.getDate());

    renderShowTimeBtnList(this.showTimeList);
  }

  void handleShowTimeBtnClick(ActionEvent event) {
    Button button = (Button) event.getSource();
    ShowTime showTime = (ShowTime) button.getUserData();
    

    removeActiveClassOf(hbShowTimeBtnBox);

    button.getStyleClass().add("active");

    movieController.setStoreShowTime(showTime);
  }

  // Render buttons - methods
  void renderFormatBtnList(ArrayList<Show> showList) {
		for (Show show: showList) {
      Button button = new Button(show.getFormat());
      button.getStyleClass().add("btn-format");
      hbTypeBtnBox.getChildren().add(button);

      button.setUserData(show);
      button.setOnAction(this::handleFormatBtnClick);
    }

    movieController.setStoreFormat(showList.get(0).getFormat());
    setActiveClassTo(hbTypeBtnBox);
  }

  void renderShowDateBtnList(ArrayList<ShowDate> showDateList) {
    hbShowDateBtnBox.getChildren().clear();

    for (ShowDate showDate: showDateList) {
      Button button = new Button(showDate.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
      button.getStyleClass().add("btn-date-time");


      button.setUserData(showDate);
      button.setOnAction(this::handleShowDateBtnClick);

      hbShowDateBtnBox.getChildren().add(button);
    }

    movieController.setStoreDate(showDateList.get(9).getDate());
    setActiveClassTo(hbShowDateBtnBox);
  }

  void renderShowTimeBtnList(ArrayList<ShowTime> showTimeList) {
    hbShowTimeBtnBox.getChildren().clear();

    for (ShowTime showTime: showTimeList) {
      Button button = new Button(showTime.getTime().format(DateTimeFormatter.ofPattern("hh:mm a")));
      button.getStyleClass().add("btn-date-time");

      button.setUserData(showTime);
      button.setOnAction(this::handleShowTimeBtnClick);
      hbShowTimeBtnBox.getChildren().add(button);
    }

    movieController.setStoreShowTime(showTimeList.get(0));
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