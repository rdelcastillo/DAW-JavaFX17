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

public class Warning extends Application {

  @Override
  public void start(Stage primaryStage) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Warning Dialog");
    alert.setHeaderText("Look, a Warning Dialog");
    alert.setContentText("Careful with the next step!");
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
