package Authentication;

import java.util.Scanner;

public class LoginRegistration {
    private final Scanner scanner;

    public LoginRegistration(Scanner scanner) {
        this.scanner = scanner;
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

    public void authenticateUser() {
        System.out.println("====== Аутентификация ======");
        System.out.print("Введите имя пользователя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Проверка аутентификации пользователя в базе данных
        boolean authenticationSuccess = authenticateInDatabase(username, password);
        if (authenticationSuccess) {
            System.out.println("Аутентификация прошла успешно.");
        } else {
            System.out.println("Ошибка: Неправильное имя пользователя или пароль.");
        }
    }
}
