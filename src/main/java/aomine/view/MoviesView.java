package aomine.view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

import java.io.IOException;

import aomine.App;
import aomine.controller.MoviesController;
import aomine.model.Movie;
import aomine.store.Store;

public class MoviesView {
  @FXML
  private FlowPane fpContainer;

  @FXML
  private Text tUsername;

  private MoviesController moviesController;
  private Store store;

  @FXML
  public void initialize() {
    moviesController = new MoviesController();
    store = Store.getInstace();
  
    tUsername.setText(store.getUser().getUsername());

    for(Movie movie: moviesController.getAll()) {
      Image image = new Image(getClass().getResource("/aomine/images/movies/" + movie.getCover()).toExternalForm());

      ImageView imageView = new ImageView(image);
      imageView.setOnMouseClicked(this::handleImageViewClick);
      imageView.setUserData(movie);
      imageView.getStyleClass().add("iv-movies");
      imageView.setFitWidth(100);
      imageView.setPreserveRatio(true);
      fpContainer.getChildren().add(imageView);
    }
  }

  void handleImageViewClick(MouseEvent event) {
    ImageView imageView = (ImageView) event.getSource();
    Movie movie = (Movie) imageView.getUserData();
    
    store.setMovie(movie);

    try {
      App.setRoot("movieView");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
