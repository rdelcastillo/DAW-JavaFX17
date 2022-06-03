/**
 * A JavaFX PasswordField control enables users of a JavaFX application to enter password which 
 * can then be read by the application. 
 * 
 * The PasswordField control does not show the texted entered into it. Instead it shows a circle
 * for each character entered. 
 * 
 * The JavaFX PasswordField control is represented by the class javafx.scene.control
 * 
 * See more at http://tutorials.jenkov.com/javafx/passwordfield.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PasswordFieldExperiments extends Application  {


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("PasswordField Experiment 1");

    // You create a PasswordField control by creating an instance of the PasswordField class. 
    
    PasswordField passwordField = new PasswordField();

    // You can get the text entered into a PasswordField using its getText() method which 
    // returns a String.
    
    Button button = new Button("Click to get password");
    button.setOnAction(action -> {
      System.out.println(passwordField.getText());
    });


    HBox hBox = new HBox(passwordField, button);

    Scene scene = new Scene(hBox);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}