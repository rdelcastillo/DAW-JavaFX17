package org.iesgrancapitan.PROGR.javafx.controls;

/**
 * Experimentamos con el control FileChooser.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FileChooserExperiments extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {

    var fxml = new FXMLLoader(getClass().getResource("fxml/FileChooserExperiments.fxml"));
    var root = fxml.<Pane>load();
    
    Scene scene = new Scene(root, 750, 400);
    scene.getStylesheets().add(getClass()
        .getResource("/org/iesgrancapitan/PROGR/javafx/css/mystyle.css").toExternalForm());
    
    primaryStage.setScene(scene);
    primaryStage.setTitle(getClass().getSimpleName());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
