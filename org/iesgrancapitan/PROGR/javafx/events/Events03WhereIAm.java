/**
 * Manejo de eventos usando JavaFX.
 * 
 * Control de la posición del cursor.
 */

package org.iesgrancapitan.PROGR.javafx.events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Events03WhereIAm extends Application {

  private static final Font FONT_IN = new Font("Liberation Mono", 20);
  private static final Font FONT_OUT = new Font("Arial Black", 100);

  @Override
  public void start(Stage primaryStage) {
    
    VBox root = new VBox();
    
    Text text = new Text();
    text.setFont(FONT_IN);
    
    root.getChildren().add(text);
    root.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(root, 800, 500);
    
    scene.setOnMouseMoved(event -> {
      text.setText("Posición relativa del ratón: "
                 + "(" + (int) event.getX() + ", " + (int) event.getY() + ")\n"
                 + "Posición absoluta del ratón: "
                 + "(" + (int) event.getScreenX() + ", " + (int) event.getScreenY() + ")");
    });
    
    scene.setOnMouseExited(value -> {
      text.setFont(FONT_OUT);
      text.setText("¿Dónde vas?"); 
    });

    scene.setOnMouseEntered(value -> {
      text.setFont(FONT_IN);
      text.setText("Hola de nuevo"); 
    });
    
    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
