/**
 * The JavaFX HTMLEditor control is a full functional rich text editor. 
 * 
 * Its implementation is based on the document editing feature of HTML5.
 * 
 * See more at https://o7planning.org/en/11113/javafx-htmleditor-tutorial
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorDemo extends Application {

  @Override
  public void start(Stage stage) {

    // Create HTMLEditor
    HTMLEditor htmlEditor = new HTMLEditor();

    String INITIAL_TEXT = "<h2>Apollo 11</h2>" 
        + "Apollo 11 was the spaceflight that landed the first humans,"
        + " Americans <a href='http://en.wikipedia.org/wiki/Neil_Armstrong'>Neil Armstrong</a>"
        + " and <a href='http://en.wikipedia.org/wiki/Buzz_Aldrin'>Buzz Aldrin</a>,"
        + " on the Moon on July 20, 1969, at 20:18 UTC."
        + " <b>Armstrong</b> became the first to step onto"
        + " the lunar surface 6 hours later on July 21 at 02:56 UTC.";

    htmlEditor.setHtmlText(INITIAL_TEXT); // Set HTML
    
    TextArea textArea = new TextArea();
    textArea.setWrapText(true);

    Button showHTMLButton = new Button("Produce HTML Code");
    showHTMLButton.setOnAction(e -> textArea.setText(htmlEditor.getHtmlText())); // Get HTML

    VBox root = new VBox();
    root.getChildren().addAll(htmlEditor, showHTMLButton, textArea);
    
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

    stage.setTitle("JavaFX HTMLEditor");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}