package org.iesgrancapitan.PROGR.javafx;

/**
 * Imprimimos la tabla de multiplicar de un número dado.
 * 
 * Usamos un FXML con su controlador. Hay creados tres ficheros FXML:
 * 
 * - Ej07FormattedMultiplicationTable.fxml: tiene definido el formato de los controles.
 * - Ej07PlainMultiplicationTable.fxml: sin formato. Se le debe incorporar el CSS a la escena.
 * - Ej07MultiplicationTableWithCSS.fxml: con CSS incorporado.
 * 
 * Para emplear los diferentes FXML hay que comentar/descomentar diferentes partes del programa. 
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

@SuppressWarnings("unused")
public class Ej07MultiplicationTable extends Application {

  private static final String CSS = "css/MultiplicationTable.css";
  private static final String FXML_FORMATTED = "fxml/Ej07FormattedMultiplicationTable.fxml";
  private static final String FXML_PLAIN = "fxml/Ej07PlainMultiplicationTable.fxml";
  private static final String FXML_WITH_CSS = "fxml/Ej07MultiplicationTableWithCSS.fxml";
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("Tabla de multiplicar");
    Parent root = FXMLLoader.load(getClass().getResource(FXML_WITH_CSS));
    Scene scene = new Scene(root);
    //scene.getStylesheets().add(getClass().getResource(CSS).toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
