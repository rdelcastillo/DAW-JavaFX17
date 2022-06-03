/**
 * A JavaFX ToggleButton is a button that can be selected or not selected. 
 * 
 * Like a button that stays in when you press it, and when you press it the next time it comes out 
 * again. Toggled - not toggled. 
 * 
 * The JavaFX ToggleButton is represented by the class javafx.scene.control.ToggleButton .
 * 
 * Implemented using FXML.
 * 
 * See more at http://tutorials.jenkov.com/javafx/togglebutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ToggleButtonExperimentsWithFXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("ToggleButton Experiments");
    Parent root = FXMLLoader.load(getClass().getResource("fxml/ToggleButtonExperiments.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
