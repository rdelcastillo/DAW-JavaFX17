/**
 * The JavaFX ProgressBar is a control capable of displaying the progress of some task. 
 * 
 * The progress is set as a double value between 0 and 1, where 0 means no progress and 1 means full 
 * progress (task completed). 
 * 
 * The JavaFX ProgressBar control is represented by the javafx.scene.control.ProgressBar class.
 * 
 * See more at http://tutorials.jenkov.com/javafx/progressbar.html
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProgressBarExample extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws InterruptedException {
    primaryStage.setTitle("ProgressBar Experiments");
    
    Text score = new Text("50");
    score.setFont(new Font("Arial", 50));

    // In order to use a JavaFX ProgressBar you must first create an instance of the ProgressBar class
    ProgressBar progressBar = new ProgressBar(0.5);

    // If score changes we update the progress bar.
    // You set the progress level of a ProgressBar via the setProgress() method.
    score.textProperty().addListener((observable, oldValue, newValue) ->  {
      progressBar.setProgress(Double.parseDouble(newValue)/100);  // [0,1]
    });

    // Buttons for change score
    Button buttonReset = new Button("Reset");
    buttonReset.setOnAction(e -> score.setText("0"));

    Button buttonNext = new Button("⏩");
    buttonNext.setOnAction(e -> { 
      int n = Integer.parseInt(score.getText());
      if (n < 100) {
        score.setText(String.valueOf(n+1));
      }
    });

    Button buttonPrev = new Button("⏪");
    buttonPrev.setOnAction(e -> {
      int n = Integer.parseInt(score.getText());
      if (n > 0) {
        score.setText(String.valueOf(n-1));
      }
    });

    // Layout, scene and stage
    VBox root = new VBox(score, progressBar, new ToolBar(buttonPrev, buttonReset, buttonNext));

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass()
        .getResource("css/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();


  }

}