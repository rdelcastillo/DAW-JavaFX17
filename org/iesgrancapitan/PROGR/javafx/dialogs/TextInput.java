/**
* A veces nos interesa crear diálogos con muy pocas intrucciones para alertas, avisos, etc...
* 
* Ejemplos sacado de https://code.makery.ch/blog/javafx-dialogs-official/
* 
*/

package org.iesgrancapitan.PROGR.javafx.dialogs;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class TextInput extends Application {

  @Override
  public void start(Stage primaryStage) {
    TextInputDialog dialog = new TextInputDialog("My name");
    dialog.setTitle("Text Input Dialog");
    dialog.setHeaderText("Look, a Text Input Dialog");
    dialog.setContentText("Please enter your name:");

    Optional<String> result = dialog.showAndWait();

    // Traditional way to get the response value.
    if (result.isPresent()){
        System.out.println("Your name: " + result.get());
    }

    // The Java 8 way to get the response value (with lambda expression).
    result.ifPresent(name -> System.out.println("Your name: " + name));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
