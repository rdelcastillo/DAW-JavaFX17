package org.iesgrancapitan.PROGR.javafx;

/**
 * Ejemplo de manejo de eventos emitidos desde un stage.
 * 
 * Más información: https://jenkov.com/tutorials/javafx/stage.html#stage-life-cycle-events
 * 
 * @author Rafael del Castillo
 */

import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ej10StageEvents extends Application {

  @Override
  public void start(Stage primaryStage) {

    // Configuramos escenario y le añadimos una escena 
    primaryStage.setTitle("Eventos en el Stage");
    primaryStage.setScene(newScene());

    // Manejo de eventos emitidos por el escenario
    primaryStage.setOnShowing(event -> printAndWait5Seconds("Se va a mostrar la ventana (en 5 segundos)"));
    primaryStage.setOnShown(event -> System.out.println("Ventana mostrada"));
    primaryStage.setOnCloseRequest(event -> System.out.println("Recibida petición de cierre de ventana"));
    primaryStage.setOnHiding(event -> printAndWait5Seconds("Se va a cerrar la ventana (en 5 segundos)"));
    primaryStage.setOnHidden(event -> System.out.println("Ventana cerrada"));

    // Manejo de eventos de teclado
    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      switch(event.getCode().getCode()) {
        case 27 : { // 27 = ESC key
          primaryStage.close();
          break;
        }
        case 10 : { // 10 = Return
          primaryStage.setWidth( primaryStage.getWidth() * 1.5);
          break;
        }
        default:  {
          System.out.println("Tecla no reconocida");
        }
      }
    });
    
    // Manejo de eventos de ratón
    primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, 
        event -> System.out.println("Botón del ratón " + getMouseButton(event) + " pulsado"));
    primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, 
        event -> System.out.println("Botón del ratón " + getMouseButton(event) + " levantado"));
    primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        event -> System.out.println("Click en [" + (int) event.getX() + "," + (int) event.getY() + "]"));
    
    primaryStage.show();
  }

  private Scene newScene() {
    Label label = new Label("¡Hola Mundo, JavaFX!");
    label.setFont(new Font("Arial", 25));
    label.setAlignment(Pos.CENTER);
    Scene scene = new Scene(label, 300, 200);
    return scene;
  }
  
  private String getMouseButton(MouseEvent event) {
    if (event.isPrimaryButtonDown()) {
      return "primario";
    } else if (event.isMiddleButtonDown()) {
      return "central";
    } else {
      return "secundario";
    }
  }

  private void printAndWait5Seconds(String msg) {
    System.out.println(msg);
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
