package edu.school21.controller;

import edu.school21.presenter.PresenterCredit;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreditController {

  @FXML
  public TextField sumField;
  @FXML
  public TextField termField;
  @FXML
  public TextField rateField;
  @FXML
  public Label monthlyPaymentLabel;
  @FXML
  public Label overpaymentLabel;
  @FXML
  public Label fullSumLabel;
  @FXML
  public ComboBox<String> paymentTypeComboBox;
  @FXML
  public Button calculateButton;
  @FXML
  public Label errorLabel;

  private PresenterCredit presenterCredit;

  @FXML
  public void initialize() {
    presenterCredit = new PresenterCredit();

    paymentTypeComboBox.getItems().addAll("Аннуитентные", "Дифференцированные");
    paymentTypeComboBox.getSelectionModel().select("Аннуитентные");
  }

  @FXML
  public void handleCalculateButton() {
    errorLabel.setText(
        presenterCredit.check(sumField.getText(), termField.getText(), rateField.getText(),
            paymentTypeComboBox.getValue()));
    presenterCredit.calculate();
    monthlyPaymentLabel.setText(presenterCredit.getPayment());
    overpaymentLabel.setText(presenterCredit.getOverpayment());
    fullSumLabel.setText(presenterCredit.getSumTotal());
  }
}
