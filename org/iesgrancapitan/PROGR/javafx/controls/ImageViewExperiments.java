/**
 * The JavaFX ImageView control can display an image inside a JavaFX GUI. 
 * The ImageView control must be added to the scene graph to be visible. 
 * The JavaFX ImageView control is represented by the class javafx.scene.image.ImageView.
 * 
 * See more at http://tutorials.jenkov.com/javafx/imageview.html
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ImageView Experiment 1");

    // You create an ImageView control instance by creating an instance of the ImageView class. 
    // The constructor of the ImageView class needs an instance of a javafx.scene.image.Image as parameter. 
    // The Image object represents the image to be displayed by the ImageView control.
    
    Image image1 = new Image(getClass().getResource("img/JavafxClasses.jpg").toString());
    ImageView imageView1 = new ImageView(image1);
    
    Image image2 = new Image("https://www.blogs.iesgrancapitan.org/wp-content/uploads/sites/18/2019/05/IES_Gran_Capitan-_Logo.jpg");
    ImageView imageView2 = new ImageView(image2);
    imageView2.setPreserveRatio(true);
    imageView2.setFitHeight(image1.getHeight());

    HBox hbox = new HBox(imageView1, imageView2);

    Scene scene = new Scene(hbox);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}