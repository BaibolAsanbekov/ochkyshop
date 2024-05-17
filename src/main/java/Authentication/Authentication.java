package Authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
        private Connection connection;

        public Authentication(Connection connection) {
            this.connection = connection;
        }

//        public boolean registerAdmin(String name, String password, String email) {
//            try {
//                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, password, email) VALUES (?, ?, ?)");
//                statement.setString(1, name);
//                statement.setString(2, password);
//                statement.setString(3, email);
//                statement.executeUpdate();
//                return true; // Регистрация прошла успешно
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return false; // Ошибка при регистрации
//            }
//        }

        public boolean registerClient(String name, String password, String email) {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, password, email) VALUES (?, ?, ?)");
                statement.setString(1, name);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.executeUpdate();
                return true; // Регистрация прошла успешно
            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Ошибка при регистрации
            }
        }

        public boolean loginAdmin(String name, String password) {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
                statement.setString(1, name);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Возвращает true, если администратор найден, иначе false
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public boolean loginClient(String name, String password) {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
                statement.setString(1, name);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Возвращает true, если клиент найден, иначе false
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }


}
