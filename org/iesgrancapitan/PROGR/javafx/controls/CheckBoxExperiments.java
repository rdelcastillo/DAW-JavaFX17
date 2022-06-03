/**
 * A JavaFX CheckBox is a button which can be in three different states: Selected, not selected 
 * and unknown (indeterminate). 
 * 
 * The JavaFX CheckBox control is represented by the class javafx.scene.control.CheckBox.
 * 
 * See more at http://tutorials.jenkov.com/javafx/checkbox.html
 * 
 */
package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CheckBoxExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("CheckBox Experiment 1");

    // You create a JavaFX CheckBox control via the CheckBox constructor
    
    CheckBox checkBox = new CheckBox("Off");

    // You can read the selected state of a CheckBox via its method isSelected()

    checkBox.setOnAction(value ->  {
      if (checkBox.isSelected()) {     
        checkBox.setText("On");
      } else {
        checkBox.setText("Off");
      }       
    });

    Button button = new Button("Check");
    button.setOnAction(value ->  {
      if (checkBox.isSelected()) {
        System.out.println("We are in ON.");
      } else {
        System.out.println("We are in OFF.");
      }       
    });

    HBox hBox = new HBox(checkBox, button);
    hBox.setPadding(new Insets(10,10,10,10));

    Scene scene = new Scene(hBox, 350, 50);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}