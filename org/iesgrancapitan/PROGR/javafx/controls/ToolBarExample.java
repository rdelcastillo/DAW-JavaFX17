/**
 * The JavaFX ToolBar class (javafx.scene.control.ToolBar) is a horizontal or vertical bar containing 
 * buttons or icons that are typically used to select different tools of a JavaFX application. 
 * 
 * Actually, a JavaFX ToolBar can contain other JavaFX controls than just buttons and icons. 
 * In fact, you can insert any JavaFX control into a ToolBar.
 * 
 * See more at http://tutorials.jenkov.com/javafx/toolbar.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolBarExample extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("ToolBar Experiment 1");

    // Buttons with icons made by Pixel perfect from www.flaticon.com
    
    Image iconCalendar = new Image(getClass().getResourceAsStream("img/icon_calendar.png"));
    ImageView imageViewCalendar = new ImageView(iconCalendar);
    Button buttonCalendar = new Button("", imageViewCalendar);
    buttonCalendar.setOnAction(value -> System.out.println("Calendar click"));

    Image iconGift = new Image(getClass().getResourceAsStream("img/icon_gift.png"));
    Button buttonGift = new Button("", new ImageView(iconGift));
    buttonGift.setOnAction(value -> System.out.println("Gift click"));
    
    Button buttonHand = new Button();
    buttonHand.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("img/icon_hand.png"))));
    buttonHand.setOnAction(value -> System.out.println("Hand click"));
    
    Button buttonWWW = new Button();
    buttonWWW.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("img/icon_www.png"))));
    buttonWWW.setOnAction(value -> System.out.println("WWW click"));
    
    Button buttonMobile = new Button();
    buttonMobile.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("img/icon_mobile.png"))));
    buttonMobile.setText("Phone me");
    buttonMobile.setOnAction(value -> System.out.println("Mobile click"));
    
    Button buttonText = new Button( "The toolbar can be displayed vertically or horizontally.\n"
                                  + "Click to change orientation.");
    buttonText.wrapTextProperty().setValue(true);
    buttonText.setOnAction(value -> System.out.println("Lorem ipsum... click"));
    
    // In order to create a JavaFX ToolBar you must first instantiate it.
    
    ToolBar toolBar = new ToolBar();
    
    // Once a JavaFX ToolBar has been created, you can add items (JavaFX components) to it. 
    // You add items to a ToolBar by obtaining its collection of items and adding the new item to 
    // that collection. 
    
    toolBar.getItems().add(buttonCalendar);
    toolBar.getItems().add(buttonGift);
    toolBar.getItems().add(buttonHand);
    toolBar.getItems().add(buttonWWW);
    toolBar.getItems().add(buttonMobile);
    
    // You can add a visual separator to a JavaFX ToolBar.
    toolBar.getItems().add(new Separator());
    toolBar.getItems().add(buttonText);

    // By default a JavaFX ToolBar displays the items added to it in a horizontal row. 
    // It is possible to get the ToolBar to display the items vertically instead, 
    // so the ToolBar becomes a vertical toolbar. 
    // To make the ToolBar display its items vertically, you call its setOrientation() method. 
    
    buttonText.setOnAction(value -> {
      System.out.println("Orientation changed.");
      if (toolBar.getOrientation().equals(Orientation.HORIZONTAL)) {
        toolBar.setOrientation(Orientation.VERTICAL);
      } else {
        toolBar.setOrientation(Orientation.HORIZONTAL);
      }
    });
  
    // Layout, scene and stage
    VBox vBox = new VBox(toolBar);
    vBox.setPadding(new Insets(10,10,10,10));

    Scene scene = new Scene(vBox, 925, 475);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

}