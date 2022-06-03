/**
 * JavaFX gives out TableView class which is used together with TableColumn and TableCell in order
 * to help you to display the data under tabular form.
 * 
 * See more at https://o7planning.org/en/11079/javafx-tableview-tutorial
 */

package org.iesgrancapitan.PROGR.javafx.controls.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableViewDemo1 extends Application {

  private static final String STYLE_SHEET =
      "/org/iesgrancapitan/PROGR/javafx/controls/css/styles.css";

  @SuppressWarnings("unchecked")
  @Override
  public void start(Stage stage) {

    var table = new TableView<UserAccount>();

    // Create column UserName (Data type of String).
    var userNameCol = new TableColumn<UserAccount, String>("User Name");

    // Create column Email (Data type of String).
    var emailCol = new TableColumn<UserAccount, String>("Email");

    // Create column FullName (Data type of String).
    var fullNameCol = new TableColumn<UserAccount, String>("Full Name");

    // Create 2 sub column for FullName.
    var firstNameCol = new TableColumn<UserAccount, String>("First Name");
    var lastNameCol = new TableColumn<UserAccount, String>("Last Name");

    // Add sub columns to the FullName
    fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

    // Active Column
    var activeCol = new TableColumn<UserAccount, Boolean>("Active");

    // Defines how to fill data for each cell.
    // Get value from property of UserAccount. .
    userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
    emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));

    // Set Sort type for userName column
    userNameCol.setSortType(TableColumn.SortType.DESCENDING);
    lastNameCol.setSortable(false);

    // Display row data
    ObservableList<UserAccount> list = getUserList();
    table.setItems(list);

    table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

    StackPane root = new StackPane(table);

    Scene scene = new Scene(root, 650, 300);
    scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());

    stage.setScene(scene);
    stage.setTitle("TableView (o7planning.org)");
    stage.show();
  }

  private ObservableList<UserAccount> getUserList() {
    UserAccount user1 = new UserAccount(1L, "smith", "smith@gmail.com", "Susan", "Smith", true);
    UserAccount user2 = new UserAccount(2L, "mcneil", "mcneil@gmail.com", "Anne", "McNeil", true);
    UserAccount user3 = new UserAccount(3L, "white", "white@gmail.com", "Kenvin", "White", false);

    return FXCollections.observableArrayList(user1, user2, user3);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
