/**
 * The JavaFX ColorPicker control enables the user to choose a color in a popup dialog. 
 * 
 * The chosen color can later be read from the ColorPicker by your JavaFX application. 
 * 
 * The JavaFX ColorPicker control is represented by the class javafx.scene.control.ColorPicker. 
 * 
 * See more at http://tutorials.jenkov.com/javafx/colorpicker.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorPickerExample extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("ColorPicker Experiments");

    Text text = new Text("How are you?");
    text.setFont(Font.font("Arial", FontWeight.BOLD, 25));
    
    // In order to use a JavaFX ColorPicker you must first create an instance of the ColorPicker class.
    
    ColorPicker colorPicker = new ColorPicker();
    
    // To read the color chosen in a JavaFX ColorPicker you call its getValue() method.
    
    Button button = new Button("Apply!");
    button.setOnAction(value ->  {
      Color color = colorPicker.getValue();
      text.setFill(color);
    });

    
    HBox hBox = new HBox(colorPicker, text, button);
    Scene scene = new Scene(hBox, 600, 100);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
  }

}