package org.iesgrancapitan.PROGR.openjfx;

/**
 * Cálculo del factorial de un número usando un FXML con su controlador.
 * 
 * @author Rafael del Castillo Gomariz
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej06Factorial extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("Cálculo del factorial");
    Parent root = FXMLLoader.load(getClass().getResource("view/Ej06Factorial.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
