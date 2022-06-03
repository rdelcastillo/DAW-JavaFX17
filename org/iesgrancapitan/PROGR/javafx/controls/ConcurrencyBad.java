/**
 * DON'T WORK.
 * 
 * See Concurrecy.java
 * 
 * In this example we implement a clock.
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.time.LocalTime;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ConcurrencyBad extends Application {
  
  private static final int PADDING = 10;
  private static final int SPACING = 5;
  private static final int FONT_SIZE = 50;
  private static final String FONT_NAME = "Arial";

  private boolean keepRunning = true;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    // clock controls

    Font font = new Font(FONT_NAME, FONT_SIZE);

    Label sep1 = new Label(":");
    sep1.setFont(font);

    Label sep2 = new Label(":");
    sep2.setFont(font);

    Label hour = new Label("00");
    hour.setFont(font);

    Label minute = new Label("00");
    minute.setFont(font);

    Label second = new Label("00");
    second.setFont(font);

    // Layout, scene and stage

    HBox root = new HBox(SPACING, hour, sep1, minute, sep2, second);
    root.setPadding(new Insets(PADDING));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Concurrency Bad: clock");
    primaryStage.setOnCloseRequest(e -> keepRunning = false);   // to stop the thread
    primaryStage.show();

    // This don't work.
    
    while (keepRunning) {
      LocalTime now = LocalTime.now();
      System.out.println(now);
      hour  .setText(String.format("%02d", now.getHour()));
      minute.setText(String.format("%02d", now.getMinute()));
      second.setText(String.format("%02d", now.getSecond()));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }   
    }
  }
}
