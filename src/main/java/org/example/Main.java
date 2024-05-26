package org.example;

import authentication.Authentication;
import ordermanager.*;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication(scanner);

        while (true) {
            System.out.println("Добро пожаловать в салон оптики!");
            System.out.println("Выберите роль:");
            System.out.println("1. Войти как Администратор");
            System.out.println("2. Зарегистрироваться как Клиент");
            System.out.println("3. Войти как Клиент");
            System.out.println("4. Выйти");
            System.out.print("Ваше действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    authentication.authenticateAdmin(); // вход админа
                    adminMenu.adminMenu();
                    break;
                case 2:
                    authentication.registerUser(); // регистер клиента
                    authentication.authenticateUser();
                    break;
                case 3:
                    authentication.authenticateUser(); // вход клиента
                    clientMenu.clientMenu();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Пожалуйста, выберите правильный вариант.");
            }
        }
    }
}