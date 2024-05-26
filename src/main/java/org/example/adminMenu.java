package org.example;

import ordermanager.order_form;

import java.util.Scanner;

public class adminMenu {
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        order_form order = new order_form();

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
                order.createOrderForm();
                break;
            case 3:
                // Удалить заказ
                order.deleteOrderForm();
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
                System.out.println("Возврат на главное меню");
                return;
            default:
                System.out.println("Пожалуйста, выберите правильный вариант.");
        }


    }
}
