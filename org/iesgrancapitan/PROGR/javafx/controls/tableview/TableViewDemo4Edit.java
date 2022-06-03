/**
 * You can edit directly on the TableView, data will be updated to Model. The following example
 * illustrates an editable TableView.
 * 
 * See more at
 * 
 * https://o7planning.org/11079/javafx-tableview#a3628445
 * http://tutorials.jenkov.com/javafx/tableview.html#editable-tableview
 * 
 */

package org.iesgrancapitan.PROGR.javafx.controls.tableview;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TableViewDemo4Edit extends Application {

  private static final int FULLNAME_WIDTH = 200;
  private static final int WIDTH_GENDER = 120;
  private static final int WIDTH_SINGLE = 100;
  private static final String STYLE_SHEET =
      "/org/iesgrancapitan/PROGR/javafx/controls/css/styles.css";

  @SuppressWarnings("unchecked")
  @Override
  public void start(Stage stage) {

    var table = new TableView<Person>();

    var fullNameCol = new TableColumn<Person, String>("Full Name");
    var genderCol = new TableColumn<Person, Gender>("Gender");
    var singleCol = new TableColumn<Person, Boolean>("Single?");

    /**
     * It is possible to make a JavaFX TableView editable. First, you must call the setEditable()
     * method of the TableView, passing a value of true as parameter.
     * 
     * Second, you must set a different cell renderer on the TableColumn's you want to be editable.
     * JavaFX comes with 4 built-in cell renderers you can use:
     * 
     * TextFieldTableCell, CheckBoxTableCell, ChoiceBoxTableCell, ComboBoxTableCell
     */

    table.setEditable(true);

    // ==== FULL NAME (TEXT FIELD) ===
    fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
    fullNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
    fullNameCol.setMinWidth(FULLNAME_WIDTH);

    // On Cell edit commit (for FullName column)
    fullNameCol.setOnEditCommit(event -> {
      int row = event.getTablePosition().getRow();
      Person person = event.getTableView().getItems().get(row);
      String newFullName = event.getNewValue();
      person.setFullName(newFullName);
    });

    // ==== GENDER (COMBO BOX) ===

    
    genderCol.setCellValueFactory(p -> {
      Person person = p.getValue();
      String genderCode = person.getGender();
      Gender gender = Gender.getByCode(genderCode);
      return new ReadOnlyObjectWrapper<Gender>(gender);
    });
    
    ObservableList<Gender> genderList = FXCollections.observableArrayList(Gender.values());
    genderCol.setCellFactory(ComboBoxTableCell.forTableColumn(genderList));
    genderCol.setMinWidth(WIDTH_GENDER);

    genderCol.setOnEditCommit(event -> {
      int row = event.getTablePosition().getRow();
      Person person = event.getTableView().getItems().get(row);
      Gender newGender = event.getNewValue();
      person.setGender(newGender.getCode());
    });

    // ==== SINGLE? (CHECK BOX) ===
    singleCol.setMinWidth(WIDTH_SINGLE);
    singleCol.setCellValueFactory(p -> {
      Person person = p.getValue();
      var singleProp = new SimpleBooleanProperty(person.isSingle());

      // Note: singleCol.setOnEditCommit(): Not work for CheckBoxTableCell.
      // When "Single?" column change.
      singleProp.addListener((observable, oldValue, newValue) -> person.setSingle(newValue));
      return singleProp;
    });

    singleCol.setCellFactory(p -> {
      var cell = new CheckBoxTableCell<Person, Boolean>();
      cell.setAlignment(Pos.CENTER);
      return cell;
    });

    ObservableList<Person> list = getPersonList();
    table.setItems(list);

    table.getColumns().addAll(fullNameCol, genderCol, singleCol);

    StackPane root = new StackPane();
    root.getChildren().add(table);

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());

    stage.setScene(scene);
    stage.setTitle(getClass().getSimpleName());
    stage.show();
  }

  private ObservableList<Person> getPersonList() {
    Person person1 = new Person("Susan Smith", Gender.FEMALE.getCode(), true);
    Person person2 = new Person("Anne McNeil", Gender.FEMALE.getCode(), true);
    Person person3 = new Person("Kevin White", Gender.MALE.getCode(), false);

    return FXCollections.observableArrayList(person1, person2, person3);
  }

  public static void main(String[] args) {
    launch(args);
  }

}
