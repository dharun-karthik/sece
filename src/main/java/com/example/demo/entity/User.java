package com.example.demo.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.util.Objects;

public class User {
  private String id;
  private String name;
  private String email;
  private String password;

  public User(final String id, final String name, final String email, final String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(final String email, final String password) {
    this.id = null;
    this.name = null;
    this.email = email;
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(email, user.email) &&
      Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public StringProperty nameProperty() {
    return new SimpleStringProperty(name);
  }

  public StringProperty emailProperty() {
    return new SimpleStringProperty(email);
  }
}
