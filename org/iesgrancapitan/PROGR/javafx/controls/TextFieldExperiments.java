/**
 * A JavaFX TextField control enables users of a JavaFX application to enter text which can then be read 
 * by the application. 
 * 
 * The JavaFX TextField control is represented by the class javafx.scene.control.TextField .
 * 
 * See more at http://tutorials.jenkov.com/javafx/textfield.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFieldExperiments extends Application  {


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("TextField Experiments");

    // You create a TextField control by creating an instance of the TextField class.
    
    TextField textField = new TextField();
    
    // You can set the text of a TextField using its setText() method. 
    
    textField.setText("Initial value");

    // You can get the text entered into a TextField using its getText() method which returns a String.
    
    Button button = new Button("Click to get text");
    button.setOnAction(action -> {
      System.out.println(textField.getText());
    });

    
    HBox hBox = new HBox(textField, button);
    hBox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(hBox);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}