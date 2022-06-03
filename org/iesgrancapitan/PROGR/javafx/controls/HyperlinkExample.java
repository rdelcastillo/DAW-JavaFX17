/**
 * The JavaFX Hyperlink control is a text that functions as a button, meaning you can configure a Hyperlink
 * to perform some action when the user clicks it. Just like a hyperlink in a web page. 
 * 
 * The JavaFX Hyperlink control is represented by the class javafx.scene.control.Hyperlink .
 * 
 * See more at http://tutorials.jenkov.com/javafx/hyperlink.html
 * 
 */
package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HyperlinkExample extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Hyperlink Example");
    
    // In order to use a JavaFX Hyperlink control you must first create a Hyperlink instance.
    Hyperlink link = new Hyperlink("Click Me!");

    // To respond to clicks on a JavaFX Hyperlink you set an action listener on the Hyperlink instance
    link.setOnAction(e -> {
      System.out.println("The Hyperlink was clicked!");
    });

    VBox vBox = new VBox(link);
    Scene scene = new Scene(vBox, 960, 600);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
