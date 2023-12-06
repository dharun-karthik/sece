package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

  @FXML
  private TextField usernameField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private void loginClicked(ActionEvent event) {
    String username = usernameField.getText();
    String password = passwordField.getText();
//    HttpClient.newBuilder(new URI("https://postman-echo.com/get"))
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

     if (isValidLogin(username, password)) {
        LoginApplication.reroute(event, "hello-view.fxml", "Hello view");
     }
  }

  private boolean isValidLogin(String username, String password) {
    return username.equals("example") && password.equals("password");
  }
}