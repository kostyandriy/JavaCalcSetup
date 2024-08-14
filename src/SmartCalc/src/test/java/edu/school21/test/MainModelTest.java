package edu.school21.test;

import edu.school21.model.MainModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MainModelTest {

  private MainModel mainModel;

  @BeforeEach
  public void initialize() {
    mainModel = new MainModel();
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/calculatorCalculatable.csv")
  public void checkCalculatable(String input, double x, double result) {
    double[] calculated = {0};
    mainModel.finalFunc(input, calculated, x);
    Assertions.assertEquals(calculated[0], result);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/calculatorUncalculatable.csv")
  public void checkUncalculatable(String input) {
    double[] calculated = {0};
    int res = mainModel.finalFunc(input, calculated, 0);
    Assertions.assertNotEquals(res, 1);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/calculatorHardCalculatable.csv")
  public void checkHardCalculatable(String input, double result) {
    double[] calculated = {0};
    mainModel.finalFunc(input, calculated, 0);
    Assertions.assertEquals(calculated[0], result, 1e-7);
  }
}