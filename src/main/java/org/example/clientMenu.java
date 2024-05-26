package org.example;

import DataManager.DataManager;
import ordermanager.order_form;

import java.util.Scanner;

public class clientMenu {
    public static void clientMenu() {
        Scanner scanner = new Scanner(System.in);
        order_form order = new order_form();

        while (true) {
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
                    order.addOrderClient();
                    break;
                case 2:
                    // просмотр заказов
                    DataManager.getClientOrders();
                    break;
                case 3:
                    // просмотр товаров
                    DataManager.viewAllProducts();
                    break;
                case 4:
                    System.out.println("Возврат на главное меню");
                    return;
                default:
                    System.out.println("Пожалуйста, выберите правильный вариант.");
            }
        }
    }
}