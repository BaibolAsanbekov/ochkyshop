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
            System.out.println("Меню администратора:");
            System.out.println("1. Просмотр заказов");
            System.out.println("2. Создать заказ");
            System.out.println("3. Удалить заказ");
            System.out.println("4. Изменить статус заказа");
            System.out.println("5. Просмотр всех товаров");
            System.out.println("6. Добавить новую оправу");
            System.out.println("7. Добавить новую линзу");
            System.out.println("8. Удалить товар");
            System.out.println("9. Вернуться в главное меню");

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
                    DataManager.viewAllProducts();
                    break;
                case 6:
                    //  Добавить новый товар
                    product.createOrderFrame();
                    break;
                case 7:
                    //  Добавить новый товар
                    product.createOrderLenses();
                    break;
                case 8:
                    // Удалить товар
                    deleteProduct();
                    break;
                case 9:
                    System.out.println("Возврат на главное меню");
                    return;
                default:
                    System.out.println("Пожалуйста, выберите правильный вариант.");
            }
        }

    }

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню удаления товара:");
        System.out.println("1. Удалить оправу");
        System.out.println("2. Удалить линзу");
        System.out.println("3. Вернуться в меню администратора");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch (choice) {
            case 1:
                System.out.print("Введите ID оправы для удаления: ");
                int frameId = scanner.nextInt();
                DataManager.deleteFrame(frameId);
                break;
            case 2:
                System.out.print("Введите ID линзы для удаления: ");
                int lensId = scanner.nextInt();
                DataManager.deleteLens(lensId);
                break;
            case 3:
        }
    }
}