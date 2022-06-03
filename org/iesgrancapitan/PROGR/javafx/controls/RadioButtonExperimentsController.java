package org.iesgrancapitan.PROGR.javafx.controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class RadioButtonExperimentsController implements Initializable {
  @FXML
  private RadioButton leftRadioButton;
  @FXML
  private RadioButton rightRadioButton;
  @FXML
  private RadioButton upRadioButton;
  @FXML
  private RadioButton downRadioButton;
  @FXML
  private ToggleGroup toggleGroup;
  @FXML
  private TextArea textArea;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub   
  }
  
  public void log(ActionEvent e) {
    System.out.println("Pulsado " + ((RadioButton) e.getSource()).getId());
  }
  
  public void fire() {
    RadioButton[] radioButtons = {leftRadioButton, rightRadioButton, upRadioButton, downRadioButton};
    
    textArea.clear();   // borramos caja de texto
    
    // ¿Están pulsados los botones left, right, up y down?
    
    // The RadioButton class has a method named isSelected which lets you determine if the RadioButton 
    // is selected or not.
    for (RadioButton radioButton: radioButtons) {
      if (radioButton.isSelected()) {
        textArea.appendText(radioButton.getId() +" is clicked\n"); 
      }
    }
    if (textArea.getText().isEmpty()) {
      textArea.setText("Left, right, up and down buttons are not pressed\n");
    }
    textArea.appendText("\n");
    
    // ¿Qué botón del ToogleGroup están pulsados?
    
    // You can group JavaFX RadioButton instances into a ToggleGroup. 
    // A ToggleGroup allows at most one RadioButton to be selected at any time.
    RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
    if (selectedRadioButton != null) {
      textArea.appendText(selectedRadioButton.getId() +" is clicked\n");
    } else {
      textArea.appendText("Radio buttons are not pressed\n");
    }

  }

}
