package org.iesgrancapitan.PROGR.openjfx.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

public class Ej06FactorialController {
  @FXML
  private TextField number;
  @FXML
  private TextField factorial;
  
  public void calculate(ActionEvent event) {
    try {
      long  f = 1;
      for (int n = Integer.parseInt(number.getText()); n > 1; n--) {
        f *= n;
      }
      factorial.setText(f + "");
    } catch (NumberFormatException e) {
      factorial.setText("El número es erróneo");
    }
  }
  
  public void initialize() {
    number.setText("0");
  }

}
