package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.database.Database.createTablesIfNotExists;

public class LoginApplication extends Application {
  public static void reroute(final ActionEvent event, final String path, final String title) {
    FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource(path));
    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
    try {
      Scene scene = new Scene(fxmlLoader.load(), 640, 320);
      stage.setTitle(title);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {
    createTablesIfNotExists();
    FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("Login.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 640, 320);
    stage.setTitle("Hell");
    stage.setScene(scene);
    stage.show();
  }
}