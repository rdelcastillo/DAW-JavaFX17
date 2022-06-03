/**
 * A JavaFX RadioButton is a button that can be selected or not selected. 
 * 
 * The RadioButton is very similar to the JavaFX ToggleButton, but with the difference that a RadioButton 
 * cannot be "unselected" once selected. 
 * 
 * If RadioButtons are part of a ToggleGroup then once a RadioButton has been selected for the first time,
 * there must be one RadioButton selected in the ToggleGroup .
 * 
 * The JavaFX RadioButton is represented by the class javafx.scene.control.RadioButton. 
 * The RadioButton class is a subclass of the ToggleButton class.
 * 
 * See more at http://tutorials.jenkov.com/javafx/radiobutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RadioButtonExperimentsWithFXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("RadioButton Experiments");
    Parent root = FXMLLoader.load(getClass().getResource("fxml/RadioButtonExperiments.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
