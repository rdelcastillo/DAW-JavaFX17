package org.iesgrancapitan.PROGR.javafx.dialogs;

/**
 * A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
 * 
 * Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
 */

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExceptionDialog2 extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {

      int a = 1/0;
      System.out.println("El resultado es " + a);

    } catch (ArithmeticException e) {
      
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Exception Dialog");
      alert.setHeaderText("Look, an Exception Dialog");
      alert.setContentText("I was unable to divide 1 by 0 and an exception was thrown");  
      alert.setResizable(true);
      alert.getDialogPane().setPrefSize(400, 200);
      
      Label label = new Label("The exception stacktrace was:");

      TextArea textArea = new TextArea(e.getMessage());
      textArea.setEditable(false);
      
      VBox expContent = new VBox(label, textArea);
     
      // Set expandable Exception into the dialog pane.
      alert.getDialogPane().setExpandableContent(expContent);
      alert.showAndWait();
    }
    
  }

  public static void main(String[] args) {
    launch(args);
  }
}
