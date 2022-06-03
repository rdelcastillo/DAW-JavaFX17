/*
 * A JavaFX Button control enables a JavaFX application to have some action executed when the 
 * application user clicks the button. 
 * 
 * The JavaFX Button control is represented by the class javafx.scene.control.Button . 
 * 
 * A JavaFX Button can have a text and an icon on it which indicate to the user what clicking the button 
 * will do.
 * 
 * See more at http://tutorials.jenkov.com/javafx/button.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Button Experiment 1");

    // You create a button control by creating an instance of the Button class
    
    Button button1 = new Button("My Button 1");
    
    // In order to respond to the click of a button you need to attach an event listener 
    // to the Button object
    
    button1.setOnAction(value ->  {
      System.out.println("'My Button 1' clicked!");
    });
    
    // The JavaFX Button control supports text wrapping of the button text. 
    // You enable text wrapping on a JavaFX Button instance using the method setWrapText()
    
    Button button2 = new Button("My Button 2 with longer text is this");
    button2.setWrapText(true);
    
    // It is possible to display an image inside a button next to the button text
    
    Image image = new Image(getClass().getResource("img/menu.png").toString());
    ImageView imageView = new ImageView(image);
    Button button3 = new Button("My Button 3", imageView);
    
    // You can set a mnemonic on a JavaFX Button instance. 
    // A mnemonic is a keyboard key which activates the button when pressed in conjunction 
    // with the ALT key. 
    
    Button button4 = new Button();
    button4.setMnemonicParsing(true);
    button4.setText("_Click");
    button4.setOnAction(value ->  {
      System.out.println("Mnemonic button clicked!");
    });
    

    HBox hbox = new HBox(button1, button2, button3, button4);

    Scene scene = new Scene(hbox, 900, 150);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
