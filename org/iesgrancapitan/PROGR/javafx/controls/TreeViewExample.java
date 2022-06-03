/**
 * The JavaFX TreeeView enables you to display tree views inside your JavaFX applications. 
 * 
 * The JavaFX TreeView is represented by the class javafx.scene.control.TreeView . 
 * 
 * See more at http://tutorials.jenkov.com/javafx/treeview.html
 */

package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    // You create a JavaFX TreeView simply by creating a new instance of the TreeView class
    TreeView<String> treeView = new TreeView<String>();

    // The items in the tree displayed by a JavaFX TreeView are represented by the TreeItem class
    TreeItem<String> rootItem = new TreeItem<String>("Tutorials");

    TreeItem<String> webItem = new TreeItem<String>("Web Tutorials");
    webItem.getChildren().add(new TreeItem<String>("HTML  Tutorial"));
    webItem.getChildren().add(new TreeItem<String>("HTML5 Tutorial"));
    webItem.getChildren().add(new TreeItem<String>("CSS Tutorial"));
    webItem.getChildren().add(new TreeItem<String>("SVG Tutorial"));
    rootItem.getChildren().add(webItem);

    TreeItem<String> javaItem = new TreeItem<String>("Java Tutorials");
    javaItem.getChildren().add(new TreeItem<String>("Java Language"));
    javaItem.getChildren().add(new TreeItem<String>("Java Collections"));
    javaItem.getChildren().add(new TreeItem<String>("Java Concurrency"));
    rootItem.getChildren().add(javaItem);
    
    treeView.setRoot(rootItem);
    
    // You can hide the root item (root node) of a JavaFX TreeView
    treeView.setShowRoot(false);

    // Layout, scene and stage
    VBox root = new VBox(treeView);
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("TreeView Experiments");
    primaryStage.show();
  }

}
