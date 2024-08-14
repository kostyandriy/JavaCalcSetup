package edu.school21.model;

public class MainModel {

  static {
    System.loadLibrary("MainModel");
  }

  public native int finalFunc(String input, double[] calculated, double x);

  public native int validX(String input);

  public native boolean validInput(String input);

  public native void per_month_ann(double sumCredit, double percent, int time, double[] annPayment,
      double[] sum, double[] diff);

  public native void per_month_diff(double sumCredit, double percent, int time,
      double[] diffPaymentFirst, double[] diffPaymentLast, double[] sum, double[] diff);
}

