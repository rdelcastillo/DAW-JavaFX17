/**
 * Stepper, which may also be known as Spinner, is a control that allows users to change incrementally 
 * the value within its associated field. Next to the field that holds the value, there are two buttons 
 * that change the value within the field upon click.
 * 
 * This control is usually used in forms. Even though this control is mainly used for numeric values 
 * (this control is sometimes called as a Numeric Stepper) other values, such as text or images, should 
 * be supported too.
 * 
 * See more at:
 * 
 *  - https://o7planning.org/en/11185/javafx-spinner-tutorial
 *  - https://wiki.openjdk.java.net/pages/viewpage.action?pageId=15368236
 *  
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpinnerExperiments extends Application {

  @Override
  public void start(Stage stage) {

    // Layout

    GridPane root = new GridPane();
    root.setHgap(10);
    root.setVgap(10);
    root.setPadding(new Insets(10));
    
    int row = 0;

    // Spinner with numerical values

    Label label1 = new Label("Select Level: ");
    root.add(label1, 0, row);

    Spinner<Integer> spinner1 = new Spinner<Integer>(); 

    SpinnerValueFactory<Integer> valueFactory1 = // Value factory
        new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 3);

    spinner1.setValueFactory(valueFactory1);
    
    root.add(spinner1, 1, row++);
    
    // Spinner with a ObservableList

    root.add(new Label("Select Month:"), 0, row);

    ObservableList<String> months = FXCollections.observableArrayList(
        "January", "February", "March", "April", 
        "May", "June", "July", "August", 
        "September", "October", "November", "December");

    Spinner<String> spinner2 = new Spinner<String>();    
    SpinnerValueFactory<String> valueFactory2 = // Value factory
        new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);

    valueFactory2.setValue("February");         // Default value

    spinner2.setValueFactory(valueFactory2);
    root.add(spinner2, 1, row++);
    
    root.add(new Separator(), 0, row++, 2, 1);

    // JavaFX Spinner can set the position and direction of the arrow, 
    // if not specified, the default is right vertical style   
    
    String[] styleClasses = new String[] { "", // Default.
        Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL, 
        Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL, 
        Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL, 
        Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL, 
        Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL
    };

    for (String styleClass : styleClasses) {
      Spinner<Integer> spinner = new Spinner<Integer>(1, 20, 10);
      spinner.getStyleClass().add(styleClass);
      root.add(new Label(styleClass), 0, row);
      root.add(spinner, 1, row++);
    }
    
    root.add(new Separator(), 0, row++, 2, 1);
    
    // You can
    
    Button button1 = new Button("Write the level on the\n"
                              + "console");
    button1.setOnAction(value -> System.out.println(spinner1.getValue()));
    root.add(button1, 0, row);
    
    Button button2 = new Button("Write the month on the\n"
                              + "console");
    button2.setOnAction(value -> System.out.println(spinner2.getValue()));
    root.add(button2, 1, row++);

    // Scene and stage

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

    stage.setTitle("Spinner Experiments 1");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}