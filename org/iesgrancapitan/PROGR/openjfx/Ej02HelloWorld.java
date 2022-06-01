package org.iesgrancapitan.PROGR.openjfx;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Mostramos una ventana con título y contenido en su interior.
 * 
 * @author Rafael del Castillo Gomariz
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Ej02HelloWorld extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Mi primera aplicación JavaFX");

    // para visualizar contenido en la ventana de la aplicación
    // hay que añadir un componente a un objeto Scene, y este al
    // objeto Stage
    Label label = new Label("¡Hola Mundo, JavaFX!");
    Scene scene = new Scene(label, 400, 200);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
