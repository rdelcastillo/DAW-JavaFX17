/**
 * The JavaFX Text control can display a text inside a JavaFX GUI. 
 * The JavaFX Text control is represented by the JavaFX class javafx.scene.text.Text . 
 * 
 * You can set the font to be used by the Text control, text size, font decorations and 
 * many other things.
 * 
 * See more at http://tutorials.jenkov.com/javafx/text.html
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {

    Text text = new Text("This is a JavaFX text.");
    
    // You can set the font of a JavaFX Text control via its setFont() method.
    // The Font class actually also lets you specify the font weight and font size.
    // Being a Shape, you can set the fill and the stroke color of a JavaFX Text control.
    
    text.setFont(Font.font("Arial", FontWeight.BOLD, 36));
    text.setFill(Color.YELLOW);
    text.setStroke(Color.GREEN);
    
    
    Scene scene = new Scene(new VBox(text), 375, 50);
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}