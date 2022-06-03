/**
 * Atrapa el círculo.
 * 
 */

package org.iesgrancapitan.PROGR.javafx.events;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Eventos04CirculoEscurridizo extends Application {

  final double WIDTH = 400;
  final double HEIGHT = 400;
  final int RADIO = 20;

  double distanciaAnterior = 0;

  @Override
  public void start(Stage primaryStage) {

    Circle circle = new Circle(WIDTH/2, HEIGHT/2, RADIO, Color.RED);

    Text heading = new Text(120, 20, "Haz click en el círculo rojo");
    Text message = new Text(WIDTH/2 - 195, HEIGHT - 20 , "");

    Group root = new Group(heading, circle, message);
    Scene scene = new Scene(root, WIDTH, HEIGHT, Color.YELLOW);

    // Cuando el ratón está cerca del círculo hacemos que se desplace 50px a la izquierda y arriba
    scene.setOnMouseMoved(e -> {
      double distanciaActual = distancia(e, circle);
      if (distanciaActual < 50 && distanciaActual < distanciaAnterior) {  // se acerca
        mueveCirculo(e, circle);
        System.out.println("Se escapó... Puedes probar con el botón del ratón pulsado.");
      }
      distanciaAnterior = distanciaActual;
    });

    // Cuando el ratón está pulsado dejamos que se acerque al círculo
    scene.setOnMouseDragged(e -> {
      message.setText("La distancia al centro del círculo es " + distancia(e, circle) + "px");
    });

    // Si atrapamos al círculo y nos despistamos se escapa
    circle.setOnMouseMoved(e -> {
      mueveCirculo(e, circle);
      System.out.println("¡Te despistaste!");
    });

    scene.setOnMouseReleased(e -> message.setText(""));
    
    // Si cerramos ventana nos despedimos
    primaryStage.setOnCloseRequest(e -> {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setContentText("¡Espero verte de nuevo pronto!");
      alert.setHeaderText(null);
      alert.showAndWait();
    });

    primaryStage.setScene(scene);
    primaryStage.setTitle("Atrapa el círculo");
    primaryStage.show();

  }

  private void mueveCirculo(MouseEvent e, Circle circle) {
    // si el puntero está a la derecha nos movemos a la izquierda y viceversa
    double signoX = Math.signum(circle.getCenterX() - e.getX());
    circle.setCenterX(e.getX() + signoX * 50);
    // si el puntero está arriba nos movemos abajo y viceversa
    double signoY = Math.signum(circle.getCenterY() - e.getY());
    circle.setCenterY(e.getY() + signoY * 50);
  }

  private static double distancia(MouseEvent e, Circle circle) {
    return Math.sqrt(Math.pow(e.getX()-circle.getCenterX(),2) + 
           Math.pow(e.getY()-circle.getCenterY(),2));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
