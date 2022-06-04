/**
 * The JavaFX WebView (javafx.scene.web.WebView) component is capable of showing web pages 
 * (HTML, CSS, SVG, JavaScript) inside a JavaFX application. 
 * 
 * As such, the JavaFX WebView is a mini browser. The WebView component is very handy when you need to show 
 * documentation (e.g. Help texts), news, blog posts or other content which needs to be downloaded from a 
 * web server at runtime.
 * 
 * The JavaFX WebView uses the WebKit open source browser engine internally to render the web pages. 
 * 
 * See more at http://tutorials.jenkov.com/javafx/webview.html
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {

  private static final String INTRO = "\r";
  private static final double ZOOM = 0.10;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {

    // creamos y configuramos un WebView
    WebView webView = new WebView();

    // campo para introducir la URL
    TextField entry = new TextField();

    // si pulsamos Intro abrimos la URL
    entry.setOnKeyTyped(e -> {
      String url;
      if(e.getCharacter().equals(INTRO))
      {
        url = entry.getText();
        if(!url.startsWith("http"))
        {
          url = "https://" + url;
        }
        webView.getEngine().load(url);
        entry.setText(webView.getEngine().getLocation());
      }
    });

    VBox root = new VBox(new Label("Introduce una URL y pulsa Intro..."), entry, webView);

    // Botones de navegación
    
    Button prev = new Button("⏪");
    prev.setOnAction(e -> {
      webView.getEngine().getHistory().go(-1);
      entry.setText(webView.getEngine().getLocation());
    });
    
    Button zoom1 = new Button("Zoom +");
    zoom1.setOnAction(e -> webView.setZoom(webView.getZoom() + ZOOM));
    
    Button zoom2 = new Button("Zoom -");
    zoom2.setOnAction(e -> webView.setZoom(webView.getZoom() - ZOOM));
    
    Button next = new Button("⏩");
    next.setOnAction(e -> {
      webView.getEngine().getHistory().go(1);
      entry.setText(webView.getEngine().getLocation());
    });
    
    HBox buttons = new HBox(20, prev, zoom1, zoom2, next);
    buttons.setAlignment(Pos.CENTER);
    root.getChildren().add(buttons);
    
    // Escena y escenario
    
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

    stage.setScene(scene);
    stage.setTitle("Mi navegador");
    stage.setResizable(false);
    stage.show();
  }
}
