package org.example;

import java.util.Scanner;

public class clientMenu {
    public static void clientMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню клиента:");
        System.out.println("1. Сделать заказ");
        System.out.println("2. Просмотреть свои заказы");
        System.out.println("3. Посмотреть каталог товаров");
        System.out.println("4. Вернуться в главное меню");

        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        switch (choice) {
            case 1:
                // создать заказ
                break;
            case 2:
                // просмотр заказов
                break;
            case 3:
                // просмотр каталогов
                break;
            case 4:
                System.out.println("Возврат на главное меню");
                return;
            default:
                System.out.println("Пожалуйста, выберите правильный вариант.");
        }
    }
}
