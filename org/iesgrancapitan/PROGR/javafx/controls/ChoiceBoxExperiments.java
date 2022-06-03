/**
 * The JavaFX ChoiceBox control enables users to choose an option from a predefined list of choices. 
 * 
 * The JavaFX ChoiceBox control is represented by the class javafx.scene.control.ChoiceBox . 
 * 
 * See more at http://tutorials.jenkov.com/javafx/choicebox.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChoiceBoxExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ChoiceBox Experiment 1");

    // You create a ChoiceBox simply by creating a new instance of the ChoiceBox class
    
    ChoiceBox<String> choiceBox = new ChoiceBox<String>();

    // You can add choices to a ChoiceBox by obtaining its item collection and add items to it
    
    choiceBox.getItems().add("Choice 1");
    choiceBox.getItems().add("Choice 2");
    choiceBox.getItems().add("Choice 3");
    
    // You can read the selected value of a ChoiceBox via its getValue() method. 
    // If no choice is selected, the getValue() method returns null
    
    Button button1 = new Button("Check");
    button1.setOnAction(value ->  {
      System.out.println("The select value is " + choiceBox.getValue()); 
    });

    
    HBox hbox = new HBox(choiceBox, button1);
    //hbox.setPadding(new Insets(10,10,10,10));
    //hbox.setSpacing(25);

    Scene scene = new Scene(hbox, 350, 50);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
