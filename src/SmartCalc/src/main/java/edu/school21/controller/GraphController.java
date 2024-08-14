package edu.school21.controller;

import edu.school21.presenter.PresenterGraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GraphController {

  @FXML
  public Button graphButton;
  @FXML
  public TextField functionField;
  @FXML
  public TextField minXField;
  @FXML
  public TextField maxXField;
  @FXML
  public Label errorField;
  @FXML
  public LineChart<Number, Number> graphArea;
  @FXML
  public NumberAxis xAxis;
  @FXML
  public NumberAxis yAxis;
  @FXML
  public Button clearGraphButton;

  private PresenterGraph presenterGraph;

  @FXML
  public void initialize() {
    presenterGraph = new PresenterGraph();
  }

  @FXML
  private void handleGraphButton(ActionEvent event) {
    errorField.setText(presenterGraph.checkInputs(functionField.getText(), minXField.getText(),
        maxXField.getText()));
    XYChart.Series<Number, Number> series = presenterGraph.calculateGraph(functionField.getText());
    if (!series.getData().isEmpty()) {
      graphArea.getData().add(series);
    }
  }

  @FXML
  private void handleClearGraphButton(ActionEvent event) {
    graphArea.getData().clear();
  }
}
