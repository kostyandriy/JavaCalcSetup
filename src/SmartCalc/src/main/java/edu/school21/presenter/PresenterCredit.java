package edu.school21.presenter;

import edu.school21.model.MainModel;

public class PresenterCredit {

  private MainModel mainModel;

  private boolean allow = false;

  private double sumCredit = 0;
  private double percent = 0;
  private int time = 0;
  private String type = "";

  private double[] annPayment = {0};
  private double[] diffPaymentFirst = {0};
  private double[] diffPaymentLast = {0};
  private double[] sum = {0};
  private double[] diff = {0};

  public PresenterCredit() {
    mainModel = new MainModel();
  }

  public void calculate() {
    if (allow) {
      sum[0] = 0;
      diff[0] = 0;

      if (type.equals("Аннуитентные")) {
        mainModel.per_month_ann(sumCredit, percent, time, annPayment, sum, diff);
      }
      if (type.equals("Дифференцированные")) {
        mainModel.per_month_diff(sumCredit, percent, time, diffPaymentFirst, diffPaymentLast, sum,
            diff);
      }
    }
  }

  public String check(String sum, String time, String precent, String type) {
    String res_out = "";
    if (validPrecent(precent) && validSum(sum) && validTime(time)) {
      allow = true;
      this.sumCredit = Double.parseDouble(sum);
      this.percent = Double.parseDouble(precent) / 1200;
      this.time = Integer.parseInt(time);
      this.type = type;
    } else {
      allow = false;
      res_out = "Incorrect input";
    }
    return res_out;
  }

  public String getPayment() {
    String res_out = "";
    if (allow) {
      if (type.equals("Аннуитентные")) {
        res_out = String.format("%.2f", annPayment[0]);
      }
      if (type.equals("Дифференцированные")) {
        res_out = String.format("%.2f", diffPaymentFirst[0]) + ".." +
            String.format("%.2f", diffPaymentLast[0]);
      }
    }
    return res_out;
  }

  public String getOverpayment() {
    String res_out = "";
    if (allow) {
      res_out = String.format("%.2f", diff[0]);
    }
    return res_out;
  }

  public String getSumTotal() {
    String res_out = "";
    if (allow) {
      res_out = String.format("%.2f", sum[0]);
    }
    return res_out;
  }

  boolean validTime(String text) {
    boolean res = false;
    int tmp = 0;
    boolean flag_empty = false, flag_large = false;
    if (text.isEmpty()) {
      flag_empty = true;
    }
    if (text.length() > 4) {
      flag_large = true;
    }
    if (!flag_empty && !flag_large) {
      if (validInt(text)) {
        tmp = Integer.parseInt(text);
        if (tmp > 0 && tmp <= 1200) {
          res = true;
        }
      }
    }
    return res;
  }

  boolean validPrecent(String text) {
    boolean res = false;
    double tmp = 0;
    boolean flag_empty = false, flag_large = false;
    if (text.isEmpty()) {
      flag_empty = true;
    }
    if (text.length() > 100) {
      flag_large = true;
    }
    if (!flag_empty && !flag_large) {
      if (validDouble(text)) {
        tmp = Double.parseDouble(text);
        if (tmp >= 0 && tmp <= 100) {
          res = true;
        }
      }
    }
    return res;
  }

  boolean validSum(String text) {
    boolean res = false;
    double tmp = 0;
    boolean flag_empty = false, flag_large = false;
    if (text.isEmpty()) {
      flag_empty = true;
    }
    if (text.length() > 15) {
      flag_large = true;
    }
    if (!flag_empty && !flag_large) {
      if (validDouble(text)) {
        tmp = Double.parseDouble(text);
        if (tmp > 0 && tmp <= 100000000) {
          res = true;
        }
      }
    }
    return res;
  }

  private boolean validInt(String text) {
    return text.matches("-?\\d+");
  }

  boolean validDouble(String text) {
    boolean res = false;
    boolean flag_er = false;
    int dot = 0;
    int len = text.length();
    for (int i = 0; i < len; i++) {
      if ((text.charAt(i) < '0' || text.charAt(i) > '9')) {
        if (text.charAt(i) == '.') {
          dot++;
        } else {
          flag_er = true;
        }
      }
    }
      if (!flag_er && dot <= 1) {
          res = true;
      }
    return res;
  }


}
