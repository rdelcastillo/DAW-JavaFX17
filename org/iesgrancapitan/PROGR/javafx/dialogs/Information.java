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

public class Information extends Application {

  @Override
  public void start(Stage primaryStage) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("I have a great message for you!");
    alert.showAndWait();

    // Without Header Text
    Alert alert2 = new Alert(AlertType.INFORMATION);
    alert2.setTitle("Information Dialog");
    alert2.setHeaderText(null);
    alert2.setContentText("I have a great message for you!\n\n"
        + "Without Header Text");
    alert2.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
