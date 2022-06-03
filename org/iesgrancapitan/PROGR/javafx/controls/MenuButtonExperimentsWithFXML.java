/**
 * The JavaFX MenuButton control can show a list of menu options which the user can choose from. 
 * 
 * The JavaFX MenuButton can show or hide the menu items. The menu items are usually shown when 
 * a little arrow button is clicked in the MenuButton. 
 * 
 * The JavaFX MenuButton control is represented by the class javafx.scene.control.MenuButton.
 * 
 * Implemented using FXML.
 * 
 * See more at http://tutorials.jenkov.com/javafx/menubutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuButtonExperimentsWithFXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("MenuButton Experiment");
    Parent root = FXMLLoader.load(getClass().getResource("fxml/MenuButtonExperiments.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
