/**
 * The JavaFX ContextMenu component provides a standard right click menu for JavaFX controls. 
 * 
 * The JavaFX ContextMenu is represented by the class javafx.scene.control.ContextMenu. 
 * 
 * See more at http://tutorials.jenkov.com/javafx/contextmenu.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContextMenuExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    
    // To use a JavaFX ContextMenu you must first create a ContextMenu instance.

    ContextMenu contextMenu = new ContextMenu();
    
    // The ContextMenu needs one or more MenuItem instances which are displayed in the menu. 
    
    MenuItem menuItem1 = new MenuItem("Click me");
    MenuItem menuItem2 = new MenuItem("Increase font size");
    MenuItem menuItem3 = new MenuItem("UPPERCASE");

    contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3);
    
    // To detect which menu item was clicked, you add listeners to the MenuItem instances.
    
    menuItem1.setOnAction(event -> System.out.println("This is a ContextMenu experiment!"));

    // A JavaFX ContextMenu needs to be attached to a JavaFX control to be active. 
    // You add a ContextMenu to a control via the setContextMenu() of a JavaFX control.
    
    TextArea textArea = new TextArea("This class is a ContextMenu Experiment.");

    textArea.setContextMenu(contextMenu);
    
    // Increase the font size of the text with a menu item
    
    menuItem2.setOnAction(event -> {
      double size = textArea.getFont().getSize() + 1;   // increased current font size
      String fontName = textArea.getFont().getName();   // current font name
      textArea.setFont(new Font(fontName, size));
    });
    
    // Change the selected text to uppercase
    
    menuItem3.setOnAction(event -> {
      String textSelectedUpper = textArea.getSelectedText().toUpperCase(); // selected text
      int firstCharPos = textArea.getSelection().getStart();    // first char position selected text
      int lastCharPos = textArea.getSelection().getEnd();       // last char position selected text
      textArea.setText(textArea.getText().substring(0, firstCharPos) +  // text prior to selection
                       textSelectedUpper +                              // text selected
                       textArea.getText().substring(lastCharPos));      // post-selection text
    });
    
    // Layout, scene and stage

    VBox vBox = new VBox(textArea);
    Scene scene = new Scene(vBox);
    //scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.setTitle("ContextMenu Experiments 1");

    primaryStage.show();
  }
}