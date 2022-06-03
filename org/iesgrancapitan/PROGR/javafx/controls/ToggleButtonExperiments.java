/**
 * A JavaFX ToggleButton is a button that can be selected or not selected. 
 * 
 * Like a button that stays in when you press it, and when you press it the next time it comes out 
 * again. Toggled - not toggled. 
 * 
 * The JavaFX ToggleButton is represented by the class javafx.scene.control.ToggleButton .
 * 
 * See more at http://tutorials.jenkov.com/javafx/togglebutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ToggleButton Experiment");
    
    // You create a JavaFX ToggleButton by creating an instance of the ToggleButton class.

    ToggleButton toggleButton1 = new ToggleButton("Left");
    ToggleButton toggleButton2 = new ToggleButton("Right");
    ToggleButton toggleButton3 = new ToggleButton("Up");
    ToggleButton toggleButton4 = new ToggleButton("Down");

    // You can group JavaFX ToggleButton instances into a ToggleGroup. 
    // A ToggleGroup allows at most one ToggleButton to be toggled (pressed) at any time. 
    
    ToggleGroup toggleGroup = new ToggleGroup();

    toggleButton1.setToggleGroup(toggleGroup);
    toggleButton2.setToggleGroup(toggleGroup);
    toggleButton3.setToggleGroup(toggleGroup);
    toggleButton4.setToggleGroup(toggleGroup);
    

    HBox hbox = new HBox(toggleButton1, toggleButton2, toggleButton3, toggleButton4);

    Scene scene = new Scene(hbox);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}