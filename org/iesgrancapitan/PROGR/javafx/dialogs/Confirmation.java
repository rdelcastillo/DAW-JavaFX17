package org.iesgrancapitan.PROGR.javafx.dialogs;

import java.util.Optional;

/**
 * A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
 * 
 * Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
 */

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Confirmation extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Confirmation Dialog
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText("Look, a Confirmation Dialog");
    alert.setContentText("Are you ok with this?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK){
      System.out.println("user chose OK"); // user chose OK
    } else {
      System.out.println("user chose CANCEL or closed the dialog"); // user chose CANCEL or closed the dialog
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
