package org.iesgrancapitan.PROGR.javafx.dialogs;

/**
 * A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
 * 
 * Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
 */

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Confirmation2 extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Confirmation Dialog
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog with Custom Actions");
    alert.setHeaderText("Look, a Confirmation Dialog with Custom Actions");
    alert.setContentText("Choose your option.");

    ButtonType buttonTypeOne = new ButtonType("One");
    ButtonType buttonTypeTwo = new ButtonType("Two");
    ButtonType buttonTypeThree = new ButtonType("Three");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == buttonTypeOne) {
      System.out.println("user chose 'One'");
    } else if (result.get() == buttonTypeTwo) {
      System.out.println("user chose 'Two'");
    } else if (result.get() == buttonTypeThree) {
      System.out.println("user chose 'Three'");
    } else {
      System.out.println("user chose CANCEL or closed the dialog");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
