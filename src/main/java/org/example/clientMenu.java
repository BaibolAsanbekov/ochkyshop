package org.example;

import DataManager.DataManager;
import ordermanager.order_form;

import java.util.Scanner;

public class clientMenu {
    public static void clientMenu() {
        Scanner scanner = new Scanner(System.in);
        order_form order = new order_form();

        while (true) {
            System.out.println("Client menu:");
            System.out.println("1. Make an order");
            System.out.println("2. View your orders");
            System.out.println("3. View product catalog");
            System.out.println("4. Back to main menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    // создать заказ
                    order.addOrderClient();
                    break;
                case 2:
                    // просмотр заказов
//                    DataManager.getClientOrders();
                    break;
                case 3:
                    // просмотр товаров
                    DataManager.viewAllProducts();
                    break;
                case 4:
                    System.out.println("Back to main menu");
                    return;
                default:
                    System.out.println("Please select the correct option.");
            }
        }
    }
}