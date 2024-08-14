package edu.school21.app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    URL fxmlLocation = getClass().getResource("/calculator.fxml");
    Parent root = FXMLLoader.load(fxmlLocation);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(new Scene(root));
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}