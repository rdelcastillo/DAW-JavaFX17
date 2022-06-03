/**
 * The JavaFX MenuButton control can show a list of menu options which the user can choose from. 
 * 
 * The JavaFX MenuButton can show or hide the menu items. The menu items are usually shown when 
 * a little arrow button is clicked in the MenuButton. 
 * 
 * The JavaFX MenuButton control is represented by the class javafx.scene.control.MenuButton.
 * 
 * See more at http://tutorials.jenkov.com/javafx/menubutton.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MenuButtonExperiments extends Application  {


  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("MenuButton Experiment");

    // Tres opciones que añadiremos al MenuButton
    MenuItem menuItem1 = new MenuItem("Option 1");
    MenuItem menuItem2 = new MenuItem("Option 2");
    MenuItem menuItem3 = new MenuItem("Option 3");

    // Podemos asociar acciones a cada instancia de MenuItem
    menuItem3.setOnAction(event -> {
      System.out.println("Option 3 selected via Lambda");
    });

    // Icono para el menú (opcional)
    Image image = new Image(getClass().getResource("img/menu.png").toString());
    ImageView imageView = new ImageView(image);

    // Creamos instancia de MenuButton añadiendo su icono y sus objetos MenuItem
    MenuButton menuButton = new MenuButton("Options", imageView, menuItem1, menuItem2, menuItem3);

    // Añadimos a la escena y escenario
    HBox hbox = new HBox(menuButton);
    Scene scene = new Scene(hbox);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}