/**
 * Este programa impide introducir datos numéricos.
 * 
 * Controlaremos la propiedad TextProperty del TextField para que solo se puedan introducir dígitos
 * y el punto (uno solo).
 * 
 * Fuente: http://acodigo.blogspot.com/2017/06/eventos-en-javafx.html
 */

package org.iesgrancapitan.PROGR.javafx.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Events05ChangeProperty extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    TextField tf1 = new TextField();
    TextArea tf3 =
        new TextArea("Arriba SOLO puedes escribir números (con o sin decimales).");
    tf3.setWrapText(true);

    VBox root = new VBox(tf1, tf3);

    Scene scene = new Scene(root, 300, 225);
    scene.getStylesheets().add(getClass().getResource("../css/mystyle.css").toExternalForm());

    // Añadimos "listener" al TextField
    tf1.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!isDecimal(newValue)) {
        tf1.setText(oldValue);
      }
    });

    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static boolean isDecimal(String cadena) {
    return cadena.matches("^[0-9]*\\.?[0-9]*$");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
