package org.iesgrancapitan.PROGR.openjfx;

/**
 * Ejemplo de manejo de eventos emitidos desde una escena.
 * 
 * @author Rafael del Castillo Gomariz
 * 
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ej12SceneEvents extends Application {

  private Scene scene;
  private TextArea textArea = new TextArea();
  private Text mouseXPosition = new Text();
  private Text mouseYPosition = new Text();

  @Override
  public void start(Stage primaryStage) {
    createScene();
    primaryStage.setScene(scene);
    primaryStage.setTitle(getClass().getSimpleName());
    primaryStage.show();
  }


  private void createScene() {
    Label label = new Label("Manejando eventos desde la escena");
    
    HBox hBox = new HBox(new Label("Ratón:"), mouseXPosition, mouseYPosition);
    hBox.setSpacing(10);
    
    VBox vBox = new VBox(label, textArea, hBox);
    vBox.setAlignment(Pos.CENTER);
    vBox.setPadding(new Insets(50));
    vBox.setSpacing(10);

    scene = new Scene(vBox, 400, 200);
    
    // Manejo de eventos desde el Scene
    scene.setOnContextMenuRequested(
        event -> textArea.appendText("Pulsado botón derecho del ratón.\n"));
    scene.setOnMouseClicked(
        event -> textArea.appendText("Click en el ratón.\n"));
    scene.setOnMouseEntered(
        event -> textArea.appendText("El ratón entra en la escena.\n"));
    scene.setOnMouseExited(
        event -> textArea.appendText("El ratón sale de la escena.\n"));
    scene.setOnMouseMoved(
        event -> {
          mouseXPosition.setText("X: " + (int) event.getX());
          mouseYPosition.setText("Y: " + (int) event.getY());
        });
  }

  public static void main(String[] args) {
    launch(args);
  }
}
