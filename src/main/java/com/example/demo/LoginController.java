package com.example.demo;

import com.example.demo.database.Database;
import com.example.demo.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.Objects;


public class LoginController {

  @FXML
  private TextField email;

  @FXML
  private PasswordField passwordField;

  @FXML
  private void loginClicked(ActionEvent event) {
    String email = this.email.getText();
    String password = passwordField.getText();
    System.out.println("Username: " + email);
    System.out.println("Password: " + password);


     if (isValidLogin(email, password)) {
        LoginApplication.reroute(event, "users-view.fxml", "Hello view");
     }
  }

  private boolean isValidLogin(String email, String password) {
    return Objects.equals(Database.getUserByEmail(email), new User(email, password));
  }
}