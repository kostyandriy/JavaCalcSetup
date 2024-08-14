package edu.school21.presenter;

import edu.school21.model.MainModel;
import edu.school21.preferences.HistoryManager;

public class PresenterCalculator {

  private MainModel mainModel;

  private double x;
  private StringBuilder history;
  private HistoryManager historyManager;

  public PresenterCalculator() {
    x = 0;
    mainModel = new MainModel();
    historyManager = new HistoryManager();
    history = new StringBuilder();
    history.append(historyManager.loadHistory());
  }

  public double getX() {
    return x;
  }

  public void addHistory(String text) {
    history.append(text);
    historyManager.saveHistory(history.toString());
  }

  public void clearHistory() {
    history = new StringBuilder();
    historyManager.saveHistory(history.toString());
  }

  public String getHistory() {
    return history.toString();
  }


  public String setX(String xText, String previousX) {
    String result_out = previousX;
    boolean flag_x_empty = false;
    boolean flag_x_large = false;

    if (xText.isEmpty()) {
      flag_x_empty = true;
    }
    if (xText.length() > 256) {
      flag_x_large = true;
    }
    if (!flag_x_empty && !flag_x_large) {
      if (mainModel.validX(xText) == 1) {
        result_out = xText;
        x = Double.parseDouble(xText);
      } else {
        result_out = "Error in setting x";
      }
    } else {
      result_out = "Error in setting x";
    }
    return result_out;
  }

  public String calculateValue(String text) {
    String result_out = "";
    boolean flag_empty = false;
    boolean flag_large = false;

    if (text.isEmpty()) {
      flag_empty = true;
    }
    if (text.length() > 256) {
      flag_large = true;
    }

    if (!flag_empty && !flag_large) {
      double[] res = {0};
      int flag = mainModel.finalFunc(text, res, x);

      if (flag == 1) {
        result_out = String.format("%.7f", res[0]);
        String history = text + " = " + res[0] + "\n";
        addHistory(history);
      }
      if (flag == -1) {
        result_out = "Error in calculation";
      }
      if (flag == -2) {
        result_out = "Error in input";
      }
    }
    if (flag_empty) {
      result_out = "Empty input";
    }
    if (flag_large) {
      result_out = "Too large input";
    }
    return result_out;
  }
}
