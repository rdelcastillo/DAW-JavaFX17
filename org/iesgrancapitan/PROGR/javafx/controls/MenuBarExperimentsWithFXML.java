package org.iesgrancapitan.PROGR.javafx.controls;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuBarExperimentsWithFXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("MenuBar Experiments 2");
    Parent root = FXMLLoader.load(getClass().getResource("fxml/MenuBarExperiments.fxml"));
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

