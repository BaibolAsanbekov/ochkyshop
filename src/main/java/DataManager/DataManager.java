package DataManager;

import java.sql.*;

public class DataManager {
        private Connection connection;

        public DataManager(String dbPath) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                createTables(); // Создание таблиц, если они не существуют
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void createTables() {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS admins (name TEXT PRIMARY KEY, password TEXT)");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS clients (name TEXT PRIMARY KEY, password TEXT)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }