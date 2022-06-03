/**
 * JavaFX uses a single-threaded rendering design, meaning only a single thread can render anything on 
 * the screen, and that is the JavaFX application thread. 
 * 
 * In fact, only the JavaFX application thread is allowed to make any changes to the JavaFX Scene Graph 
 * in general.
 * 
 * A single-threaded rendering design is easier to implement correctly, but long-running tasks that run 
 * within the JavaFX application thread make the GUI unresponsive until the task is completed. 
 * 
 * No JavaFX GUI controls react to mouse clicks, mouse over, keyboard input while the JavaFX application 
 * thread is busy running that task.
 * 
 * See more at http://tutorials.jenkov.com/javafx/concurrency.html
 * 
 * In this example we implement a clock.
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import java.time.LocalTime;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Concurrency extends Application {
  
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
    
    /*
     * Sometimes you absolutely need to perform some long-running task in a JavaFX application. 
     * You don't want to leave the GUI unresponsive while the task is running, so you want to run the 
     * ask in its own thread. However, you would like the running task to update the GUI - either along
     * the way, or when the task is completed. The task thread cannot update the GUI (the scene graph) 
     * directly - but JavaFX has a solution for this problem.
     * 
     * JavaFX contains the Platform class which has a runLater() method. The runLater() method takes a 
     * Runnable which is executed by the JavaFX application thread when it has time. From inside this 
     * Runnable you can modify the JavaFX scene graph.
     */

    Thread taskThread = new Thread(new Runnable() {
      private LocalTime now;

      @Override
      public void run() {
        while (keepRunning) {
          now = LocalTime.now();
          System.out.println(now);
          
          Platform.runLater(new Runnable() {    // controls JavaFX update
            @Override
            public void run() {
              hour  .setText(String.format("%02d", now.getHour()));
              minute.setText(String.format("%02d", now.getMinute()));
              second.setText(String.format("%02d", now.getSecond()));
            }
          });
          
          try {                                 // wait one second
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }     
        }
      }
    });
    
    // Layout, scene and stage
    
    HBox root = new HBox(SPACING, hour, sep1, minute, sep2, second);
    root.setPadding(new Insets(PADDING));
    
    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Concurrency: clock");
    primaryStage.setOnCloseRequest(e -> keepRunning = false);   // to stop the thread
    primaryStage.show();
    
    taskThread.start();
  }
}
