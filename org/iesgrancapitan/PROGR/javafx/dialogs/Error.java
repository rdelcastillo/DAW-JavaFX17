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

public class Error extends Application {

  @Override
  public void start(Stage primaryStage) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Look, an Error Dialog");
    alert.setContentText("Ooops, there was an error!");
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
