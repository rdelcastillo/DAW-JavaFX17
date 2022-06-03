package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderExample extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Slider Experiments");
    
    Text text = new Text("Change the slider, you see...");

    // To use a JavaFX Slider you must first create an instance of the Slider class.
    // The Slider constructor used above takes three parameters: min, max and initial values.
    
    Slider slider = new Slider(0, 100, 50);
   
    // You can read the value of a Slider as selected by the user via the getValue() method.
    // For tracking Slider changes we need a ChangeListener
    // See more at https://code.makery.ch/blog/javafx-8-event-handling-examples/
    
    slider.valueProperty().addListener((observable, oldValue, newValue) ->  {
      System.out.println("The slider old value is " + oldValue + " and the new value is " + newValue);
      text.setText("The slider value is " + observable.getValue());  // or slider.getValue()
    });

    // You can make the JavaFX Slider show marks for the ticks when it renders the slider. 
    // You do so using its setShowTickMarks() method. 
    
    slider.setShowTickMarks(true);    
    
    // You can make the handle of the JavaFX Slider snap to the ticks using the Slider setSnapToTicks() 
    // method, passing a parameter value of true it. 

    slider.setSnapToTicks(true);    
    
    // You can make the JavaFX Slider show tick labels for the ticks when it renders the slider. 
    // You do so using its setShowTickLabels() method. 
        
    slider.setShowTickLabels(true);
    
    // You can set the major tick unit of a JavaFX Slider control. 
    // The major tick unit is how many units the value changes every time the user moves 
    // the handle of the Slider one tick. 
    
    slider.setMajorTickUnit(10);
    
    // You can set the minor tick count of a JavaFX Slider via the setMinorTickCount() method. 
    // The minor tick count specifies how many minor ticks there are between two of the major ticks. 
    
    slider.setMinorTickCount(5);
    
    VBox vBox = new VBox(slider, text);
    
    Scene scene = new Scene(vBox, 800, 100);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
  }

}