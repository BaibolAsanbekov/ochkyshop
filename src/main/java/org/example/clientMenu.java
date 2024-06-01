package org.example;

import DataManager.DataManager;
import ordermanager.order_form;

import java.util.List;
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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // создать заказ
                    order.addOrderClient();
                    break;
                case 2:
                    // просмотр заказов
                    System.out.println("Enter your client ID:");
                    int clientId = scanner.nextInt();
                    scanner.nextLine();
                    List<String> orders = DataManager.getClientOrders(clientId);
                    if (orders.isEmpty()) {
                        System.out.println("No orders found for this client ID.");
                    } else {
                        for (String orderDetail : orders) {
                            System.out.println(orderDetail);
                        }
                    }
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