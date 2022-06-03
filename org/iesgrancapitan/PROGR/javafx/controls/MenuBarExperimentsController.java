package org.iesgrancapitan.PROGR.javafx.controls;

import javafx.fxml.FXML;

import javafx.scene.control.ToggleGroup;

import javafx.event.ActionEvent;

import javafx.event.Event;

public class MenuBarExperimentsController {
  @FXML
  private ToggleGroup toggleGroup;

  // Event Listener on Menu.onHidden
  @FXML
  public void menu2OnHidden(Event event) {
    System.out.println("Hidden Menu 2");
  }

  // Event Listener on Menu.onHiding
  @FXML
  public void menu2OnHiding(Event event) {
    System.out.println("Hiding Menu 2");
  }

  // Event Listener on Menu.onShowing
  @FXML
  public void menu2OnShowing(Event event) {
    System.out.println("Showing Menu 2");
  }

  // Event Listener on Menu.onShown
  @FXML
  public void menu2OnShown(Event event) {
    System.out.println("Shown Menu 2");
  }

  // Event Listener on MenuItem.onAction
  @FXML
  public void menu3Item1(ActionEvent event) {
    System.out.println("Menu Item 1 Selected");
  }

  // Event Listener on MenuItem.onAction
  @FXML
  public void exit(ActionEvent event) {
    System.exit(0);
  }
}
