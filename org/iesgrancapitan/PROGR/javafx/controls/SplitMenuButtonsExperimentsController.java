package org.iesgrancapitan.PROGR.javafx.controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class SplitMenuButtonsExperimentsController implements Initializable {
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub    
  }
  
  public void fireMenuItem3() {
    System.out.println("Option 3 selected via Lambda"); 
  }
  
  public void fireSplitMenuButton() {
    System.out.println("SplitMenuButton clicked!");
  }

}
