package org.iesgrancapitan.PROGR.javafx.controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class ToggleButtonExperimentsController implements Initializable {
  @FXML
  private ToggleButton leftToggleButton;
  @FXML
  private ToggleButton rightToggleButton;
  @FXML
  private ToggleButton upToggleButton;
  @FXML
  private ToggleButton downToggleButton;
  @FXML
  private ToggleGroup toggleGroup;
  @FXML
  private TextArea textArea;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub   
  }
  
  public void log(ActionEvent e) {
    System.out.println("Pulsado " + ((ToggleButton) e.getSource()).getId());
  }
  
  public void fire() {
    ToggleButton[] toggleButtons = {leftToggleButton, rightToggleButton, upToggleButton, downToggleButton};
    
    textArea.clear();   // borramos caja de texto
    
    // ¿Están pulsados los botones left, right, up y down?
    
    // The ToggleButton class has a method named isSelected which lets you determine if the 
    // ToggleButton is selected (pressed) or not
    for (ToggleButton toggleButton: toggleButtons) {
      if (toggleButton.isSelected()) {
        textArea.appendText(toggleButton.getId() +" is clicked\n"); 
      }
    }
    if (textArea.getText().isEmpty()) {
      textArea.setText("Left, right, up and down buttons are not pressed\n");
    }
    textArea.appendText("\n");
    
    // ¿Qué botón del ToogleGroup están pulsados?
    
    // You can group JavaFX ToggleButton instances into a ToggleGroup. 
    // A ToggleGroup allows at most one ToggleButton to be toggled (pressed) at any time. 
    // The ToggleButton instances in a ToggleGroup thus functions similarly to radio buttons.
    ToggleButton selectedToggleButton = (ToggleButton) toggleGroup.getSelectedToggle();
    if (selectedToggleButton != null) {
      textArea.appendText(selectedToggleButton.getId() +" is clicked\n");
    } else {
      textArea.appendText("Toggle buttons are not pressed\n");
    }

  }

}
