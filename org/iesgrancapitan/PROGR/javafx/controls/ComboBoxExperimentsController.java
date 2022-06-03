package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class ComboBoxExperimentsController implements Initializable {

  @FXML
  private ComboBox<String> comboBox;

  // Event Listener on Button.onAction

  public void check(ActionEvent event) {
    System.out.println("The select value is " + comboBox.getValue());
  }
  

  // Event Listener on CombpBox.onAction

  public void comboCheck(ActionEvent event) {
    System.out.println("The select value now is " + comboBox.getValue());
  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    comboBox.getItems().addAll("Choice 1", "Choice 2", "Choice 3");    
  }
}
