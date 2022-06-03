/**
 * A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
 * 
 * Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
 * 
 */

package org.iesgrancapitan.PROGR.javafx.dialogs;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CustomIcon extends Application {

  @Override
  public void start(Stage primaryStage) {

    Alert dialog = new Alert(AlertType.INFORMATION);
    dialog.setTitle("Information Dialog");
    dialog.setHeaderText("Look, an Information Dialog");
    dialog.setContentText("I have a great message for you!");

    // Get the Stage.
    Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

    // Add a custom icon.
    stage.getIcons().add(new Image(this.getClass().getResource("icono.jpeg").toString()));
    
    dialog.showAndWait();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
