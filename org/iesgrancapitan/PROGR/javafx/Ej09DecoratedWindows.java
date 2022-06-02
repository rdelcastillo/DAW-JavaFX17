package org.iesgrancapitan.PROGR.javafx;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Creamos ventanas con diferentes decoraciones.
 * 
 * @author Rafael del Castillo Gomariz
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ej09DecoratedWindows extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX App");
    primaryStage.setScene(new Scene(new Label("Ejemplos de decoración de ventanas")));
    primaryStage.show();
    
    // vector con 5 escenarios
    Stage[] stages = new Stage[5];
    for (int i = 0; i < stages.length; i++) {
      stages[i] = new Stage();
      stages[i].setX(100 * (i+1));
      stages[i].setY(100 * (i+1));
      Scene scene = new Scene(new Label("Soy la ventana " + (i+1)),200,50);
      stages[i].setScene(scene);
    }
    
    // vector con estilos de decoración de ventana
    StageStyle[] estilos = {StageStyle.DECORATED, StageStyle.UNDECORATED, 
                            StageStyle.UNIFIED, StageStyle.TRANSPARENT, 
                            StageStyle.UTILITY};
    
    // aplicamos estilo a cada escenario, ponemos título del escenario en la ventana y mostramos    
    for (int i=0; i<stages.length; i++) {
      stages[i].initStyle(estilos[i]);
      stages[i].setTitle(estilos[i].toString());
      stages[i].show();
    }

  }
}