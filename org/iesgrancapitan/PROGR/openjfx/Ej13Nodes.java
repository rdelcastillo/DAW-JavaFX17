package org.iesgrancapitan.PROGR.openjfx;

/**
 * Ejemplo de cómo acceder a las propiedades de los nodos.
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ej13Nodes extends Application {
  
  TextArea data = new TextArea();

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Pruebas con nodos");
    primaryStage.setScene(newScene());
    primaryStage.show();
  }

  private Scene newScene() {
    
    // Capturamos el click dentro de las cajas de texto
    TextArea textArea1 = new TextArea("Caja 1\n");
    textArea1.setOnMouseClicked(event -> ponDatos(event));
    textArea1.setId("Caja 1");
    TextArea textArea2 = new TextArea("Caja 2\n");
    textArea2.setOnMouseClicked(event -> ponDatos(event));
    textArea2.setId("Caja 2");
    
    Border border = new Border(new BorderStroke(Color.BLACK, 
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    
    HBox hBox1 = new HBox(10, textArea1, textArea2);
    hBox1.setPadding(new Insets(25));
    hBox1.setBorder(border);

    // Dos cajas de texto con binding (lo que se ponga en una aparece en la otra)
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    textField2.textProperty().bind(textField1.textProperty());
    textField1.textProperty().addListener((prop, oldVal, newVal) -> 
      data.appendText("Caja de texto cambiada: '" + oldVal + "' a '" + newVal + "'\n"));

    Label label = new Label("Cajas de texto con binding");
    
    HBox hBox2 = new HBox(100, label, textField1, textField2);
    hBox2.setAlignment(Pos.CENTER);
    
    VBox vBox = new VBox(20, hBox1, hBox2, data);
    vBox.setPadding(new Insets(50));
    
    // Controlamos los cambios del ancho en el layout
    vBox.widthProperty().addListener((prop, oldVal, newVal) -> 
      System.out.println("widthProperty cambiada: " + oldVal + " a " + newVal));
    
    return new Scene(vBox);
  }

  private void ponDatos(MouseEvent event) {
    TextArea textArea = (TextArea) event.getSource();
    textArea.appendText("Realizado click.\n");
    
    data.appendText("Click en TextArea con id " + textArea.getId() + "\n");
    data.appendText("Posición del ratón: [" + event.getX() + ", " + event.getY() + "]\n");
    data.appendText("Posición en Layout: [" + textArea.getLayoutX() + ", " + textArea.getLayoutY() + "]\n");
    data.appendText("-----\n");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
