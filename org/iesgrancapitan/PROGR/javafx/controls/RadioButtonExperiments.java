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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class RadioButtonExperiments extends Application  {


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("RadioButton Experiment");

    // You create a JavaFX RadioButton using its constructor
    
    RadioButton radioButton1 = new RadioButton("Left");
    RadioButton radioButton2 = new RadioButton("Right");
    RadioButton radioButton3 = new RadioButton("Up");
    RadioButton radioButton4 = new RadioButton("Down");
    
    // You can group JavaFX RadioButton instances into a ToggleGroup. 
    // A ToggleGroup allows at most one RadioButton to be selected at any time.

    ToggleGroup radioGroup = new ToggleGroup();

    radioButton1.setToggleGroup(radioGroup);
    radioButton2.setToggleGroup(radioGroup);
    radioButton3.setToggleGroup(radioGroup);
    radioButton4.setToggleGroup(radioGroup);

    HBox hbox = new HBox(radioButton1, radioButton2, radioButton3, radioButton4);

    Scene scene = new Scene(hbox);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}