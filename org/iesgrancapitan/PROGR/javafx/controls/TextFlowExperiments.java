package org.iesgrancapitan.PROGR.javafx.controls;

/**
 * TextFlow is special layout designed to lay out rich text. 
 * It can be used to layout several Text nodes in a single text flow. 
 * 
 * The TextFlow uses the text and the font of each Text node inside of it 
 * plus it own width and text alignment to determine the location for each child. 
 * 
 * A single Text node can span over several lines due to wrapping and the visual 
 * location of Text node can differ from the logical location due to bidi reordering.
 * 
 * Paragraphs are separated by '\n' present in any Text child.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextFlowExperiments extends Application {

  @Override
  public void start(Stage primaryStage) {
    Text text1 = new Text("Big italic red text");
    text1.setFill(Color.RED);
    text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
    Text text2 = new Text(" little bold blue text\n");
    text2.setFill(Color.BLUE);
    text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
    TextFlow textFlow = new TextFlow(text1, text2);
    
    for (double size = 1; size <= 50; size += 0.5) {
      Text text = new Text("I'm a Text node and font size is " + size + "\n");
      text.setFont(Font.font(size));
      textFlow.getChildren().add(text);
    }
    
    ScrollPane pane = new ScrollPane(textFlow);
    
    primaryStage.setScene(new Scene(pane));
    primaryStage.setTitle(getClass().getSimpleName());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
