/**
 * The JavaFX Label control can display a text or image label inside a JavaFX GUI. 
 * The label control must be added to the scene graph to be visible.
 *  
 * The JavaFX Label control is represented by the class javafx.scene.control.Label .
 * 
 * See more at http://tutorials.jenkov.com/javafx/label.html
 */
package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LabelExperiments extends Application  {


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Label Experiment");

    // You create a label control instance by creating an instance of the Label class    
    Label label = new Label("My Label");

    Scene scene = new Scene(label);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}