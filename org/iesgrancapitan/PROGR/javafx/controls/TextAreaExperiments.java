/**
 * A JavaFX TextArea control enables users of a JavaFX application to enter text spanning multiple lines,
 * which can then be read by the application. 
 * 
 * The JavaFX TextArea control is represented by the class javafx.scene.control.TextArea .
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextAreaExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("TextArea Experiment 1");

    // You create a TextArea control by creating an instance of the TextArea class.
    
    TextArea textArea = new TextArea();
    
    // You can read the text entered into a TextArea via its getText() method. 
    // You can set the text of a TextArea control via its setText() method. 

    Button button = new Button("Click to get text");
    button.setOnAction(action -> {
      System.out.println(textArea.getText());
      textArea.setText("Clicked!");
    });
    

    VBox vbox = new VBox(textArea, button);

    Scene scene = new Scene(vbox);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}