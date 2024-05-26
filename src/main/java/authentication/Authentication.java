package authentication;

import java.sql.*;
import java.util.Scanner;

public class Authentication {
    private final Scanner scanner;

    public Authentication(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.println("====== Регистрация ======");
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Ошибка: Пароли не совпадают.");
            return;
        }

        // Добавить логику для регистрации пользователя в базе данных
        boolean registrationSuccess = registerToDatabase(username, password);
        if (registrationSuccess) {
            System.out.println("Пользователь успешно зарегистрирован.");
        } else {
            System.out.println("Ошибка при регистрации пользователя.");
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
                System.out.println("Ошибка: Пользователь с таким именем уже существует.");
                return false;
            }

            // Регистрация нового пользователя
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            insertStatement.executeUpdate();

            // Закрытие соединения с базой данных
            connection.close();

            return true; // Регистрация прошла успешно
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Ошибка при регистрации
        }
    }

    public void authenticateUser() {
        while (true) {
            System.out.println("====== Аутентификация ======");
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            boolean authenticationSuccess = authInDatabase(username, password);
            if (authenticationSuccess) {
                System.out.println("Аутентификация прошла успешно.");
                // Вызов метода для отображения меню клиента
                displayClientMenu();
                break;
            } else {
                System.out.println("Ошибка: Неправильное имя пользователя или пароль.");
            }
        }
    }

    private void displayClientMenu() {
    }

    private boolean authInDatabase(String username, String password) {
        try {
            // Установка соединения с базой данных
            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");

            // Поиск пользователя с заданным именем и паролем
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            // Проверка наличия пользователя в базе данных
            boolean userExists = resultSet.next();

            // Закрытие соединения с базой данных
            connection.close();

            return userExists; // Возвращает true, если пользователь существует и аутентификация прошла успешно
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Ошибка при аутентификации
        }
    }

    public void authenticateAdmin() {
        System.out.println("====== Аутентификация Админа ======");
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Проверка аутентификации пользователя в базе данных
        boolean authenticationSuccess = authInDatabase(username, password);
        if (authenticationSuccess) {
            System.out.println("Аутентификация прошла успешно.");
        } else {
            System.out.println("Ошибка: Неправильное имя пользователя или пароль.");
        }
    }

}
