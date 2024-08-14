package edu.school21.test;

import edu.school21.model.MainModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CreditModelTest {

  private MainModel mainModel;

  @BeforeEach
  public void initialize() {
    mainModel = new MainModel();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/creditAnnPayment.csv")
  public void checkCreditAnnPayment(double sumCredit, double percent, int time, double resSum,
      double resPayment, double resDiff) {
    double[] annPayment = {0};
    double[] sum = {0};
    double[] diff = {0};

    mainModel.per_month_ann(sumCredit, percent / 1200, time, annPayment, sum, diff);

    Assertions.assertEquals(resPayment, annPayment[0], 1e-2);
    Assertions.assertEquals(resSum, sum[0], 1e-2);
    Assertions.assertEquals(resDiff, diff[0], 1e-2);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/creditDiffPayment.csv")
  public void checkCreditDiffPayment(double sumCredit, double percent, int time, double resSum,
      double resPaymentFirst, double resPaymentLast, double resDiff) {
    double[] diffPaymentFirst = {0};
    double[] diffPaymentLast = {0};
    double[] sum = {0};
    double[] diff = {0};

    mainModel.per_month_diff(sumCredit, percent / 1200, time, diffPaymentFirst, diffPaymentLast,
        sum, diff);

    Assertions.assertEquals(resPaymentFirst, diffPaymentFirst[0], 1e-2);
    Assertions.assertEquals(resPaymentLast, diffPaymentLast[0], 1e-2);
    Assertions.assertEquals(resSum, sum[0], 1e-2);
    Assertions.assertEquals(resDiff, diff[0], 1e-2);
  }
}
