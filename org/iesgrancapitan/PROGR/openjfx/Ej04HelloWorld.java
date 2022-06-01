package org.iesgrancapitan.PROGR.openjfx;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Mostramos una ventana con título a pantalla completa.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ej04HelloWorld extends Application {

  @Override
  public void start(Stage primaryStage) {
    
    // creamos control etiqueta
    Label label = new Label("¡Hola Mundo, JavaFX!");
    label.setFont(new Font("Arial", 50));
    label.setAlignment(Pos.CENTER);
    
    // creamos escena con el control anterior
    Scene scene = new Scene(label);

    // colocamos escena en el escenario primario y ponemos pantalla completa
    primaryStage.setScene(scene);
    primaryStage.setFullScreen(true);
    primaryStage.setTitle("Saludos");
    
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}