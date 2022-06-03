package org.iesgrancapitan.PROGR.javafx.controls;

/**
 * Ejemplo de uso de FileChooser.
 * 
 * Más información en http://tutorials.jenkov.com/javafx/filechooser.html
 * 
 * @author Rafael del Castillo.
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class FileChooserExperimentsController {
  @FXML
  private TextField fichero;
  @FXML
  private TextArea visor;

  // Event Listener on Button.onAction
  @FXML
  public void escogerFichero(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Ficheros Java", "*.java"),
        new FileChooser.ExtensionFilter("Ficheros Texto", "*.txt"));

    Stage stage = (Stage) visor.getScene().getWindow();

    try {
      File file = fileChooser.showOpenDialog(stage);
      String fileContent = Files.readString(file.toPath());
      visor.setText(fileContent);
      fichero.setText(file.getName());

    } catch (IOException | NullPointerException e) {
      fichero.setText("No se ha seleccionado un fichero correcto.");
    }

  }
}
