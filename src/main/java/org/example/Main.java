package org.example;

import Authentication.LoginRegistration;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginRegistration LR = new LoginRegistration(scanner);

        while (true) {
            System.out.println("Добро пожаловать в салон оптики!");
            System.out.println("Выберите роль:");
            System.out.println("1. Войти как Администратор");
            System.out.println("2. Зарегистрироваться как Клиент");
            System.out.println("3. Войти как Клиент");
            System.out.println("4. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    LR.authenticateAdmin(); // вход админа
                    adminMenu();
                    break;
                case 2:
                    LR.registerUser(); // регистер клиента
                    LR.authenticateUser();
                    break;
                case 3:
                    LR.authenticateUser(); // вход клиента
                    clientMenu();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Пожалуйста, выберите правильный вариант.");
            }
        }
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню администратора:");
        System.out.println("1. Просмотр заказов");
        System.out.println("2. Создать заказ");
        System.out.println("3. Удалить заказ");
        System.out.println("4. Изменить статус заказа");
        System.out.println("5. Просмотр всех товаров");
        System.out.println("6. Добавить новый товар");
        System.out.println("7. Удалить товар");
        System.out.println("8. Вернуться в главное меню");

        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        switch (choice) {
            case 1:
                // Просмотр заказов
                break;
            case 2:
                // Создать заказ
                break;
            case 3:
                // Удалить заказ
                break;
            case 4:
                // Изменить статус заказа
                break;
            case 5:
                // Просмотр всех товаров
                break;
            case 6:
                //  Добавить новый товар
                break;
            case 7:
                // Удалить товар
                break;
            case 8:
                System.out.println("До свидания!");
                return;
            default:
                System.out.println("Пожалуйста, выберите правильный вариант.");
        }


    }
    public static void clientMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню клиента:");
        System.out.println("1. Сделать заказ");
        System.out.println("2. Просмотреть свои заказы");
        System.out.println("3. Посмотреть каталог товаров");
        System.out.println("4. Вернуться в главное меню");

        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        // Здесь можно добавить вызов соответствующих методов для обработки выбора клиента
    }


    }