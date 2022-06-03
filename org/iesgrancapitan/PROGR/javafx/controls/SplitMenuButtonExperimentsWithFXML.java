/**
 * The JavaFX SplitMenuButton control can show a list of menu options which the user can choose 
 * from, as well as a button which the user can click on when a menu option has been chosen. 
 * 
 * The JavaFX SplitMenuButton can show or hide the menu items. 
 * 
 * The menu items are usually shown when a little arrow button is clicked in the SplitMenuButton.
 * 
 * The JavaFX SplitMenuButton control is represented by the class javafx.scene.control.SplitMenuButton.
 * 
 * The difference with a JavaFX MenuButton is the primary button. 
 *  
 * See more at http://tutorials.jenkov.com/javafx/splitmenubutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SplitMenuButtonExperimentsWithFXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("SplitMenuButton Experiment");
    Parent root = FXMLLoader.load(getClass().getResource("fxml/SplitMenuButtonExperiments.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}