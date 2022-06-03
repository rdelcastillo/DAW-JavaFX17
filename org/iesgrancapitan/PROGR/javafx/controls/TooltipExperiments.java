/**
 * The JavaFX Tooltip class (javafx.scene.control.Tooltip) can display a small popup with explanatory
 * text when the user hovers the mouse over a JavaFX control. 
 * 
 * A Tooltip is a well-known feature of modern desktop and web GUIs. 
 * 
 * A Tooltip is useful to provide extra help text in GUIs where there is not space enough available 
 * to have an explanatory text visible all the time, e.g. in the button text.
 * 
 * See more at http://tutorials.jenkov.com/javafx/tooltip.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TooltipExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Tooltip Experiment 1");
    
    // To use the JavaFX Tooltip class you must create a Tooltip instance.
    
    Tooltip tooltip1 = new Tooltip("This is a Tooltip Control");
    
    // Once you have created a Tooltip instance you need to add it to a JavaFX component 
    // to make it active.

    Button button1 = new Button("My Button 1");
    button1.setTooltip(tooltip1);
    
    // You can set a graphic icon for a Tooltip via the setGraphic() method. 
    
    Tooltip tooltip2 = new Tooltip("This is a Tooltip Control with a graphic icon");
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("img/eye.png")));
    imageView.setPreserveRatio(true);
    imageView.setFitWidth(100);
    tooltip2.setGraphic(imageView);

    Button button2 = new Button("My Button 2");
    button2.setTooltip(tooltip2);
    
    HBox hbox = new HBox(button1, button2);

    Scene scene = new Scene(hbox);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
