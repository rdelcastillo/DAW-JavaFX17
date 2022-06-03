package org.iesgrancapitan.PROGR.javafx.dialogs;

/**
 * A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
 * 
 * Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
 */

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ExceptionDialog extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {
      int a = 1/0;
      System.out.println("El resultado es " + a);
    } catch (Exception e) {
      
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Exception Dialog");
      alert.setHeaderText("Look, an Exception Dialog");
      alert.setContentText("I was unable to divide 1 by 0 and an exception was thrown");  
      
      alert.showAndWait();

    }
    
  }

  public static void main(String[] args) {
    launch(args);
  }
}
