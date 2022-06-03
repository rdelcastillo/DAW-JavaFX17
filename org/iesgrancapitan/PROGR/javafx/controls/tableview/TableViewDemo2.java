package org.iesgrancapitan.PROGR.javafx.controls.tableview;

/**
 * It is possible to use standard Java Map instances for your data items instead of creating a
 * specific class for them (as the Person class in earlier examples).
 * 
 * To use a Map as a data item the TableColumn instances attached to the TableView need to use a
 * special cell value factory called a MapValueFactory.
 * 
 * See more at http://tutorials.jenkov.com/javafx/tableview.html
 */

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableViewDemo2 extends Application {

  private static final int WIDTH_COLUMN = 150;
  private static final String STYLE_SHEET =
      "/org/iesgrancapitan/PROGR/javafx/controls/css/styles.css";

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public void start(Stage primaryStage) {

    TableView tableView = new TableView();

    TableColumn<Map, String> firstNameColumn = new TableColumn<>("firstName");
    firstNameColumn.setCellValueFactory(new MapValueFactory<>("firstName"));

    TableColumn<Map, String> lastNameColumn = new TableColumn<>("lastName");
    lastNameColumn.setCellValueFactory(new MapValueFactory<>("lastName"));

    tableView.getColumns().addAll(firstNameColumn, lastNameColumn);
    tableView.getColumns()
        .forEach(column -> ((TableColumn<Map, String>) column).setMinWidth(WIDTH_COLUMN));

    ObservableList<Map<String, String>> items =
        FXCollections.<Map<String, String>>observableArrayList();

    Map<String, String> item1 = new HashMap<>();
    item1.put("firstName", "Randall");
    item1.put("lastName", "Kovic");
    items.add(item1);

    Map<String, String> item2 = new HashMap<>();
    item2.put("firstName", "Irmelin");
    item2.put("lastName", "Satoshi");
    items.add(item2);

    tableView.getItems().addAll(items);

    StackPane root = new StackPane(tableView);
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.setTitle("TableView with Map");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
