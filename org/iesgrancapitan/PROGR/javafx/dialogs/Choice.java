/**
* A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
* 
* Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
* 
*/

package org.iesgrancapitan.PROGR.javafx.dialogs;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

public class Choice extends Application {

  @Override
  public void start(Stage primaryStage) {
    ArrayList<String> choices = new ArrayList<String>();
    choices.add("a");
    choices.add("b");
    choices.add("c");

    ChoiceDialog<String> dialog = new ChoiceDialog<String>("b", choices);
    dialog.setTitle("Choice Dialog");
    dialog.setHeaderText("Look, a Choice Dialog");
    dialog.setContentText("Choose your letter:");
    
    Optional<String> result = dialog.showAndWait();
    
    // Traditional way to get the response value.
    if (result.isPresent()){
        System.out.println("Your choice: " + result.get());
    }

    // The Java 8 way to get the response value (with lambda expression).
    result.ifPresent(letter -> System.out.println("Your choice: " + letter));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
