package org.iesgrancapitan.PROGR.javafx.controls.tableview;

/**
 * En este ejemplo vemos como poner valores de las celdas de la tabla personalizados.
 * 
 * De una lista de enteros hacemos una tabla con columnas para valores calculados de los mismos.
 * 
 * Más información en: https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/control/TableColumn.html
 * 
 * @author Rafael del Castillo.
 */

import java.util.List;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableViewDemo3 extends Application {

  private static final int HEIGHT_TABLE = 300;
  private static final int WIDTH_TABLE = 500;
  private static final int WIDTH_COLUMN_NUMBER = 100;
  private static final String STYLE_SHEET =
      "/org/iesgrancapitan/PROGR/javafx/controls/css/styles.css";

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public void start(Stage primaryStage) {

    var tableView = new TableView();

    // Columna para el número
    TableColumn<Integer, Integer> numberColumn = new TableColumn<>("number");
    numberColumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper(p.getValue()));
    numberColumn.setMinWidth(WIDTH_COLUMN_NUMBER);
    numberColumn.setStyle("-fx-alignment: CENTER");

    // Columna para el número multiplicado por 2
    TableColumn<Integer, Integer> numberx2Column = new TableColumn<>("x2");
    numberx2Column.setCellValueFactory(p -> new ReadOnlyObjectWrapper(p.getValue() * 2));

    // Columna para el número multiplicado por 5
    TableColumn<Integer, Integer> numberx5Column = new TableColumn<>("x5");
    numberx5Column.setCellValueFactory(p -> new ReadOnlyObjectWrapper(p.getValue() * 5));

    // Columna para la raíz cuadrada del número
    TableColumn<Integer, Double> numberSqrtColumn = new TableColumn<>("√2");
    numberSqrtColumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper(Math.sqrt(p.getValue())));

    // Añadimos columnas a la tabla
    tableView.getColumns().addAll(numberColumn, numberx2Column, numberx5Column, numberSqrtColumn);

    // Lista con los números sobre los que haremos los cálculos
    ObservableList<Integer> items =
        FXCollections.<Integer>observableArrayList(List.of(2, 5, 7, 10, 15));
    tableView.setItems(items);

    // Creación de la escena y esenario
    StackPane root = new StackPane(tableView);
    Scene scene = new Scene(root, WIDTH_TABLE, HEIGHT_TABLE);
    scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.setTitle(getClass().getSimpleName());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
