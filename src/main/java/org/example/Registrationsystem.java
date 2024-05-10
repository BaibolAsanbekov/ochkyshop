package org.example;

import java.sql.*;

public class Registrationsystem {
    private static final String DB_URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // Создаем таблицу пользователей, если она еще не существует
            String createUserTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL," +
                    "password TEXT NOT NULL)";
            stmt.executeUpdate(createUserTableSQL);

            // Проверяем, существует ли пользователь с таким именем
            String checkUserSQL = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement checkUserStmt = conn.prepareStatement(checkUserSQL)) {
                checkUserStmt.setString(1, "testUser");
                ResultSet resultSet = checkUserStmt.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Пользователь с таким именем уже существует");
                } else {
                    // Регистрируем нового пользователя
                    String registerUserSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
                    try (PreparedStatement registerUserStmt = conn.prepareStatement(registerUserSQL)) {
                        registerUserStmt.setString(1, "testUser");
                        registerUserStmt.setString(2, "testPassword");
                        registerUserStmt.executeUpdate();
                        System.out.println("Регистрация прошла успешно");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
