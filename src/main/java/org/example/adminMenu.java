package org.example;

import DataManager.DataManager;
import ProductManagment.product_form;
import ordermanager.order_form;

import java.util.Scanner;

public class adminMenu {
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        order_form order = new order_form();
        product_form product = new product_form();
        DataManager dataManager = new DataManager();


        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View orders");
            System.out.println("2. Create an order");
            System.out.println("3. Delete order");
            System.out.println("4. Change order status");
            System.out.println("5. View all products");
            System.out.println("6. Add a new frame");
            System.out.println("7. Add a new lens");
            System.out.println("8. Remove product");
            System.out.println("9. Back to main menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Просмотр заказов
                    dataManager.viewAllOrders();
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
                    order.updateOrderStatusForm();
                    break;
                case 5:
                    // Просмотр всех товаров
                    DataManager.viewAllProducts();
                    break;
                case 6:
                    //  Добавить новую оправу
                    product.createOrderFrame();
                    break;
                case 7:
                    //  Добавить новую линзу
                    product.createOrderLenses();
                    break;
                case 8:
                    // Удалить товар
                    deleteProduct();
                    break;
                case 9:
                    System.out.println("Return to the main menu");
                    return;
                default:
                    System.out.println("Please select the correct option.");
            }
        }

    }

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product deletion menu:");
        System.out.println("1. Remove the frame");
        System.out.println("2. Remove the lens");
        System.out.println("3. Back to the administrator menu");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the ID of the frame to delete: ");
                int frameId = scanner.nextInt();
                DataManager.deleteFrame(frameId);
                break;
            case 2:
                System.out.print("Enter the ID of the lens to remove: ");
                int lensId = scanner.nextInt();
                DataManager.deleteLens(lensId);
                break;
            case 3:
        }
    }
}