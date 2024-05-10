package org.example;

import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db"; // Replace this with the path to your SQLite database file

        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}