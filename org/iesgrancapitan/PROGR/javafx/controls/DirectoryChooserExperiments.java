package org.iesgrancapitan.PROGR.javafx.controls;

/**
 * Ejemplo de uso de DirectoryChooser.
 * 
 * Más información en http://tutorials.jenkov.com/javafx/directorychooser.html
 * 
 * @author Rafael del Castillo.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryChooserExperiments extends Application {

  Stage primaryStage;
  String directorioInicial = System.getProperty("user.home");
  
  @Override
  public void start(Stage primaryStage) {

    TextArea editor = new TextArea();
    TextField fichero = new TextField("mi_fichero.txt");
    Button guardar = new Button("Guardar");
    guardar.setOnAction(event -> guardarFichero(editor.getText(), fichero.getText()));

    HBox hBox = new HBox(20, new Label("Nombre fichero"), fichero, guardar);
    hBox.setAlignment(Pos.CENTER);
    VBox root = new VBox(new Label("Escriba su texto"), editor, hBox);

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass()
        .getResource("/org/iesgrancapitan/PROGR/javafx/css/mystyle.css").toExternalForm());

    this.primaryStage = primaryStage;
    primaryStage.setScene(scene);
    primaryStage.setTitle("Editor de textos");
    primaryStage.show();
  }

  private void guardarFichero(String texto, String fichero) {
    String ficheroEnDisco = null;
    
    try {
      // Escogemos directorio con el control DirectoryChooser
      DirectoryChooser directoryChooser = new DirectoryChooser();
      directoryChooser.setInitialDirectory(new File(directorioInicial));
      directoryChooser.setTitle("Escoge la carpeta donde se almacenará el texto");
      File directorio = directoryChooser.showDialog(primaryStage);
      
      // Escribimos el contenido del texto en disco
      ficheroEnDisco = directorio.getCanonicalPath() + "/" + fichero;
      Files.writeString(Paths.get(ficheroEnDisco), texto);
      Mensaje("Operación realizada con éxito", null, AlertType.INFORMATION);
      
      // Recordamos para la siguiente operación el directorio
      directorioInicial = directorio.getCanonicalPath();

    } catch (IOException e) {
      Mensaje("Datos erróneos", "No se podido escribir en " + ficheroEnDisco, AlertType.ERROR);

    } catch (NullPointerException e) {
      System.out.println("NullPointerException, se debe haber pulsado 'Cancelar'");
    }
  }
  
  public static void Mensaje(String content, String header, AlertType type) {
    Alert alert = new Alert(type);
    alert.setContentText(content);
    alert.setHeaderText(header);
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
