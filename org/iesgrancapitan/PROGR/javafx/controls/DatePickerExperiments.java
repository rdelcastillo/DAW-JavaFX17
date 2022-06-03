/**
 * JavaFX DatePicker control enables the user to enter a date or choose a date from a wizard-like 
 * popup dialog. 
 * 
 * The popup dialog shows only valid dates, so this is an easier way for users to choose a date and 
 * ensure that both the date and date format entered in the date picker text field is valid. 
 * 
 * The JavaFX DatePicker is represented by the class javafx.scene.control.DatePicker .
 * 
 * The DatePicker is a subclass of the ComboBox class, and thus shares some similarities with this class.
 * 
 * See more at http://tutorials.jenkov.com/javafx/datepicker.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DatePickerExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("DatePicker Experiment 1");

    // You create a DatePicker control via the constructor of the DatePicker class
    
    DatePicker datePicker = new DatePicker();

    // Reading the date selected in the DatePicker can be done using its getValue() method
    // The getValue() returns a LocalDate object representing the date selected in the DatePicker
    
    Button button = new Button("Read Date");
    button.setOnAction(action -> {
      LocalDate value = datePicker.getValue();
      System.out.println(value);
    });
    

    HBox hbox = new HBox(datePicker, button);

    Scene scene = new Scene(hbox, 600, 75);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}