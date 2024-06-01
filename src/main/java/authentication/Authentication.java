package authentication;

import java.sql.*;
import java.util.Scanner;

public class Authentication {
    private final Scanner scanner;

    public Authentication(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.println("====== Registration ======");
        System.out.print("Enter your user name: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Repeat the password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Error: Passwords don't match.");
            return;
        }

        // Добавить логику для регистрации пользователя в базе данных
        boolean registrationSuccess = registerToDatabase(username, password);
        if (registrationSuccess) {
            System.out.println("User successfully registered.");
        } else {
            System.out.println("Error during user registration.");
        }
    }

    private boolean registerToDatabase(String username, String password) {
        try {
            // Установка соединения с базой данных
            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");

            // Проверка существования пользователя с таким же именем
            PreparedStatement checkStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            checkStatement.setString(1, username);
            ResultSet resultSet = checkStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Error: A user with this name already exists.");
                return false;
            }

            // Регистрация нового пользователя
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            insertStatement.executeUpdate();

            // Закрытие соединения с базой данных
            connection.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void authenticateUser() {
        while (true) {
            System.out.println("====== Authentication ======");
            System.out.print("Enter your user name: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            boolean authenticationSuccess = authInDatabase(username, password);
            if (authenticationSuccess) {
                System.out.println("Authentication was successful.");
                // Вызов метода для отображения меню клиента
                displayClientMenu();
                break;
            } else {
                System.out.println("Error: Incorrect user name or password.");
            }
        }
    }

    private void displayClientMenu() {
    }

    private boolean authInDatabase(String username, String password) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");


            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();


            boolean userExists = resultSet.next();


            connection.close();

            return userExists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void authenticateAdmin() {
        System.out.println("====== Admin Authentication ======");
        System.out.print("Enter a user name: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();


        boolean authenticationSuccess = authInDatabase(username, password);
        if (authenticationSuccess) {
            System.out.println("Authentication was successful.");
        } else {
            System.out.println("Error: Incorrect user name or password.");
            
        }
    }
}