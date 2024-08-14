package edu.school21.presenter;

import edu.school21.model.MainModel;
import javafx.scene.chart.XYChart;

public class PresenterGraph {

  private MainModel mainModel;
  private boolean allow = false;

  private int minX = -10;
  private int maxX = 10;
  private double h = 0;

  public PresenterGraph() {
    mainModel = new MainModel();
  }

  public String checkInputs(String function, String minX, String maxX) {
    String res = "";
    res = check(function);
    if (!res.isEmpty()) {
      allow = false;
      return res;
    }
    res = setAxis(minX, maxX);
    if (!res.isEmpty()) {
      allow = false;
      return res;
    }
    allow = true;
    return "";
  }


  public XYChart.Series<Number, Number> calculateGraph(String text) {
    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    if (!allow) {
      return series;
    }
    series.setName(text);
    if (maxX - minX >= 0) {
      h = 0.01;
    }

    if (maxX - minX >= 20) {
      h = 0.1;
    }

    if (maxX - minX >= 200) {
      h = 1;
    }

    if (maxX - minX >= 10000) {
      h = 2;
    }

    if (maxX - minX >= 100000) {
      h = 4;
    }

    if (maxX - minX >= 200000) {
      h = 50;
    }

    if (maxX - minX >= 400000) {
      h = 100;
    }

    if (maxX - minX >= 800000) {
      h = 150;
    }

    if (maxX - minX >= 1300000) {
      h = 200;
    }

    double X = 0;
    double[] Y = {0};
    for (X = minX; X <= maxX; X += h) {
      int flag_ok = mainModel.finalFunc(text, Y, X);
      if (flag_ok == 1) {
        series.getData().add(new XYChart.Data<>(X, Y[0]));
      }
    }
    return series;
  }

  private String check(String text) {
    String res_out = "";
    boolean flag_empty = false;
    boolean flag_large = false;

    if (text.isEmpty()) {
      flag_empty = true;
    }
    if (text.length() > 256) {
      flag_large = true;
    }

    if (!flag_empty && !flag_large) {
      String res = text.replaceAll(" ", "");
      if (!mainModel.validInput(res)) {
        res_out = "Incorrect input";
      }
    }
    if (flag_empty) {
      res_out = "Empty input";
    }
    if (flag_large) {
      res_out = "Too large input";
    }
    return res_out;
  }

  private String setAxis(String x_min_text,
      String x_max_text) {
    String res_out = "";
    boolean flag_validCord = false;
    if (validString(x_min_text) && validString(x_max_text)) {
      if (validCord(Integer.parseInt(x_min_text), Integer.parseInt(x_max_text))) {
        flag_validCord = true;
      }
    }
    if (!flag_validCord) {
      res_out = "Invalid cords";
      allow = false;
    } else {
      minX = Integer.parseInt(x_min_text);
      maxX = Integer.parseInt(x_max_text);
    }
    return res_out;
  }

  private boolean validInt(String text) {
    return text.matches("-?\\d+");
  }

  private boolean validString(String input) {
    boolean res = false;
    boolean flag_empty = false;
    boolean flag_large = false;

    if (input.isEmpty()) {
      flag_empty = true;
    }
    if (input.length() > 9) {
      flag_large = true;
    }

    if (!flag_empty && !flag_large) {
      if (validInt(input)) {
        res = true;
      } else {
        allow = false;
        return false;
      }
    }
    return res;
  }

  private boolean validCord(int min, int max) {
    boolean res = false;
    if (min <= max) {
      if (max >= -1000000 && max <= 1000000) {
        if (min >= -1000000) {
          res = true;
        }
      }
    }
    return res;
  }
}
