package com.example.demo.database;

import com.example.demo.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

  private static final String DB_URL = "jdbc:mysql://localhost:3308/projectdb";
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "rootpassword";

  public static void createTablesIfNotExists() {
    try {
      Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      Statement statement = connection.createStatement();

      String createTableQuery = "CREATE TABLE IF NOT EXISTS user ("
        + "id INT AUTO_INCREMENT PRIMARY KEY,"
        + "name VARCHAR(50),"
        + "email VARCHAR(100),"
        + "password VARCHAR(30)"
        + ")";

      statement.executeUpdate(createTableQuery);
      System.out.println("Table created (if it didn't exist) successfully!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static User getUserByEmail(String email) {
    String query = "SELECT * FROM user WHERE email = ?";

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, email);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        return new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("email"),
          resultSet.getString("password"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public static List<User> getAllUsers() {
    String query = "SELECT * FROM user";
    List<User> users = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        users.add(
          new User(resultSet.getString("id"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getString("password")
          )
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return users;
  }

}

