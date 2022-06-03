/**
 * The JavaFX MenuBar provides JavaFX applications with a visual drop down menu similar to that most 
 * desktop applications have at the top of their application window. 
 * 
 * The JavaFX MenuBar is represented by the class javafx.scene.control.MenuBar .
 * 
 *  See more at http://tutorials.jenkov.com/javafx/menubar.html
 *  
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuBarExperiments extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("MenuBar Experiments 1");

    // Before you can use the JavaFX MenuBar you must create a MenuBar instance.

    MenuBar menuBar = new MenuBar();

    // Once the MenuBar instance is created, you can add Menu instances to it.
    // A Menu instance represents a single vertical menu with nested menu items. 
    // You can add multiple MenuBar instances to a MenuBar to add multiple vertical drop down menus.

    Menu menu1 = new Menu("Menu 1");
    Menu menu2 = new Menu("Menu 2");

    menuBar.getMenus().addAll(menu1, menu2);    // add various menus

    // You can set a graphic icon for a Menu by calling its setGraphic() method. 
    // The graphic icon will be displayed next to the text label of the menu. 

    Menu menu3 = new Menu("Menu 3");
    ImageView imageView3 = new ImageView(new Image(getClass().getResourceAsStream("img/icon_hand.png")));
    imageView3.setPreserveRatio(true);
    imageView3.setFitHeight(20);
    menu3.setGraphic(imageView3);

    menuBar.getMenus().add(menu3);      // add a single menu

    // Once you have created a Menu instance you must add one or more MenuItem instances to it. 
    // Each MenuItem corresponds to a menu item in the menu it is added to.

    MenuItem menu1Item1 = new MenuItem("Item 1");
    MenuItem menu1Item2 = new MenuItem("Item 2");
    MenuItem menu1Item3 = new MenuItem("Item 3");

    menu1.getItems().add(menu1Item1);
    menu1.getItems().add(menu1Item2);

    // The MenuBar supports menu item separators. 

    menu1.getItems().add(new SeparatorMenuItem());
    menu1.getItems().add(menu1Item3);

    // You can add an graphic icon to a MenuItem by calling its setGraphic() method, 
    // passing as parameter the graphic you want to use for the given MenuItem.

    MenuItem menu2Item1 = new MenuItem("Item 1");
    ImageView imageView21 = new ImageView(new Image(getClass().getResourceAsStream("img/icon_calendar.png")));
    imageView21.setPreserveRatio(true);
    imageView21.setFitHeight(20);
    menu2Item1.setGraphic(imageView21);

    MenuItem menu2Item2 = new MenuItem("Item 2");
    ImageView imageView22 = new ImageView(new Image(getClass().getResourceAsStream("img/icon_mobile.png")));
    imageView22.setPreserveRatio(true);
    imageView22.setFitHeight(20);
    menu2Item2.setGraphic(imageView22);

    menu2.getItems().addAll(menu2Item1, menu2Item2);

    // A JavaFX Menu instance can fire several events which you can listen for in your application

    menu2.setOnShowing(e -> { System.out.println("Showing Menu 2"); });      
    menu2.setOnShown  (e -> { System.out.println("Shown Menu 2"); });
    menu2.setOnHiding (e -> { System.out.println("Hiding Menu 2"); });
    menu2.setOnHidden (e -> System.out.println("Hidden Menu 2")); // withouts brackets (one instruction is not necessary)

    // In order to respond to the selection of a MenuItem you must set an event listener 
    // on the MenuItem.

    MenuItem menu3Item1 = new MenuItem("Item 1");
    menu3Item1.setOnAction(e -> {
      System.out.println("Menu Item 1 Selected");
    });

    menu3.getItems().add(menu3Item1);

    // The JavaFX MenuBar supports multiple layers of menus.
    // A menu nested inside another menu is called a submenu. 
    // The Menu class extends the MenuItem class and can therefore be used as a menu item 
    // inside another Menu instance.

    Menu subMenu = new Menu("Submenu");
    MenuItem menu3Item21 = new MenuItem("Item submenu 1");
    MenuItem menu3Item22 = new MenuItem("Item submenu 2");
    subMenu.getItems().addAll(menu3Item21, menu3Item22);
    menu3.getItems().add(subMenu);

    // The JavaFX MenuBar supports using check menu items in a menu. 
    // A check menu item is a menu item that can be "selected" and remain selected until unselected later.
    // A small check mark is displayed next to the check menu item as long as it remains selected.
    // The check menu item is represented by the CheckMenuItem class.

    CheckMenuItem checkMenuItem1 = new CheckMenuItem("Check item1");
    CheckMenuItem checkMenuItem2 = new CheckMenuItem("Check item2");
    Menu menu4 = new Menu("Menu 4");
    menu4.getItems().addAll(checkMenuItem1, checkMenuItem2);

    menuBar.getMenus().add(menu4);

    // The JavaFX MenuBar also supports radio menu items. 
    // Radio menu items are menu items of which only one of a set of menu items can be selected.
    // The radio menu item is represented by the RadioMenuItem. 
    // The RadioMenuItem instance must be added to a ToggleGroup to make them mutually exclusive. 
    // That is how JavaFX knows which RadioMenuItem instance belong together.

    Menu menu5 = new Menu("Menu 5");

    RadioMenuItem choice1Item = new RadioMenuItem("Choice 1");
    RadioMenuItem choice2Item = new RadioMenuItem("Choice 2");
    RadioMenuItem choice3Item = new RadioMenuItem("Choice 3");

    ToggleGroup toggleGroup = new ToggleGroup();
    toggleGroup.getToggles().add(choice1Item);
    toggleGroup.getToggles().add(choice2Item);
    toggleGroup.getToggles().add(choice3Item);
    
    choice2Item.setSelected(true);      // Default

    menu5.getItems().addAll(choice1Item, choice2Item, choice3Item);

    menuBar.getMenus().add(menu5);

    // The JavaFX MenuBar also supports using custom JavaFX controls as menu items. 
    // To do so you need to use the CustomMenuItem class.
    // The CustomMenuItem class has a setContent() method which you can use to set the 
    // custom JavaFX control to show in the menu.

    Menu menu6 = new Menu("Menu 6");

    Slider slider = new Slider(0, 100, 50);

    CustomMenuItem customMenuItem1 = new CustomMenuItem();
    customMenuItem1.setContent(slider);
    customMenuItem1.setHideOnClick(false); // keep the menu open while the user interacts with the control
    menu6.getItems().add(customMenuItem1);

    Button button = new Button("Custom Menu Item Button");
    CustomMenuItem customMenuItem2 = new CustomMenuItem();
    customMenuItem2.setContent(button);
    customMenuItem2.setHideOnClick(false);
    menu6.getItems().add(customMenuItem2);

    menuBar.getMenus().add(menu6);

    // You can add a keyboard shortcut to a menu in JavaFX.
    // This is so that instead of clicking a menu item to access it, it can be accessed by pressing 
    // the Alt key followed by the first letter in the menu item.
    // In order to do so, all you have to do is add an underscore(_) before the name of the menu.

    Menu menu7 = new Menu("_Options");
    MenuItem menu7Item1 = new MenuItem("Option 1");
    menu7.getItems().add(menu7Item1);

    menuBar.getMenus().add(menu7);

    // You can add a keyboard shortcut to a menu item in JavaFX with an accelerator key 

    MenuItem exit = new MenuItem("Exit");
    
    KeyCombination ctrlX = new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN);
    exit.setAccelerator(ctrlX);

    exit.setOnAction(event -> {
      System.out.println("This is all folks!");
      System.exit(0);
    });
    
    menu7.getItems().add(exit);

    // Layout, scene and stage

    VBox vBox = new VBox(menuBar);
    vBox.setStyle("-fx-alignment: TOP; -fx-padding: 0");

    Scene scene = new Scene(vBox, 800, 600);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
