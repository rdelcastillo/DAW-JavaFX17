package org.iesgrancapitan.PROGR.openjfx;

/**
 * Imprimimos la tabla de multiplicar de un número dado.
 * 
 * Usamos un FXML con su controlador.
 * 
 * @author Rafael del Castillo Gomariz
 * 
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej07MultiplicationTable extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("Tabla de multiplicar");
    Parent root = FXMLLoader.load(getClass().getResource("view/Ej07MultiplicationTable.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
