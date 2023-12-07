package com.example.demo;

import com.example.demo.database.Database;
import com.example.demo.entity.User;
import com.example.demo.enums.UserRole;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;

import java.util.List;

public class UserViewController {
  @FXML
  private TableView<User> tableView;

  @FXML
  private TableColumn<User, String> nameColumn;

  @FXML
  private TableColumn<User, String> emailColumn;

  @FXML
  private TableColumn<UserRole, UserRole> dropdownColumn;

  public void initialize() {
    List<User> userList = Database.getAllUsers();

    ObservableList<User> observableList = FXCollections.observableArrayList(userList);

    nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

    dropdownColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<UserRole>(UserRole.ADMIN));

    dropdownColumn.setCellFactory(
      ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList(UserRole.values())));

    tableView.setItems(observableList);
  }
}