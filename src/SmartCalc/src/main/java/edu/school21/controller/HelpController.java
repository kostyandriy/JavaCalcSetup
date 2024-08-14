package edu.school21.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class HelpController {

  @FXML
  private void handleCalcButton(ActionEvent event) throws Exception {
    URL fxmlLocation = getClass().getResource("/calchelp.fxml");
    Parent root = FXMLLoader.load(fxmlLocation);
    Stage graphStage = new Stage();
    graphStage.setScene(new Scene(root));
    graphStage.setTitle("Calc help");
    graphStage.centerOnScreen();
    graphStage.show();
  }

  @FXML
  private void handleGraphButton(ActionEvent event) throws Exception {
    URL fxmlLocation = getClass().getResource("/graphhelp.fxml");
    Parent root = FXMLLoader.load(fxmlLocation);
    Stage graphStage = new Stage();
    graphStage.setScene(new Scene(root));
    graphStage.setTitle("Graph help");
    graphStage.centerOnScreen();
    graphStage.show();
  }

  @FXML
  private void handleCreditButton(ActionEvent event) throws Exception {
    URL fxmlLocation = getClass().getResource("/credithelp.fxml");
    Parent root = FXMLLoader.load(fxmlLocation);
    Stage graphStage = new Stage();
    graphStage.setScene(new Scene(root));
    graphStage.setTitle("Credit help");
    graphStage.centerOnScreen();
    graphStage.show();
  }
}
