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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SplitMenuButtonExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("SplitMenuButton Experiment");

    // Tres opciones que añadiremos al MenuButton
    
    MenuItem menuItem1 = new MenuItem("Option 1");
    MenuItem menuItem2 = new MenuItem("Option 2");
    MenuItem menuItem3 = new MenuItem("Option 3");

    // Podemos asociar acciones a cada instancia de MenuItem
    
    menuItem3.setOnAction(event -> {
      System.out.println("Option 3 selected via Lambda");
    });

    // Creamos instancia de SplitMenuButton añadiendo su icono y sus objetos MenuItem
    
    SplitMenuButton splitMenuButton = new SplitMenuButton(menuItem1, menuItem2, menuItem3);
    splitMenuButton.setText("Click here!");

    // Podemos asociar una acción al botón de la instancia SplitMenuButton 

    splitMenuButton.setOnAction((e) -> {
      System.out.println("SplitMenuButton clicked!");
    });

    // Añadimos a la escena y escenario
    
    HBox hbox = new HBox(splitMenuButton);
    Scene scene = new Scene(hbox);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}