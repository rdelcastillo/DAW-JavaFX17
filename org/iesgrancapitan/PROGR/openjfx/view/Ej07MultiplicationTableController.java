package org.iesgrancapitan.PROGR.openjfx.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class Ej07MultiplicationTableController {
  @FXML
  private TextField number;
  @FXML
  private TextArea table;

  // Event Listener on Button.onAction
  @FXML
  public void generateMultiplicationTable(ActionEvent event) {
    try {
      table.clear();
      int n = Integer.parseInt(number.getText());
      for (int i = 1; i <= 10; i++) {
        table.appendText(n + " x " + i + " = " + n * i + "\n");
      }
    } catch (NumberFormatException e) {
      String errorMessage = "ERROR: " + number.getText() + " no es un número.";
      System.err.println(errorMessage);
      table.setText(errorMessage);
    }
  }
  
  @FXML
  public void initialize() {
    number.setText("0");
  }
}
