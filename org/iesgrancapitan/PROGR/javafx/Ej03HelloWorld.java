package org.iesgrancapitan.PROGR.javafx;

/**
 * Usamos un fichero FXML que tiene el diseño de la GUI.
 *  
 * @author Rafael del Castillo
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej03HelloWorld extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("fxml/Ej03HelloWorld.fxml"));
    primaryStage.setTitle("Hola Mundo!!!");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
