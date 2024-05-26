package ordermanager;

import DataManager.DataManager;

import java.util.Scanner;

public class order_form {
    private final Scanner scanner;

    public order_form() {
        this.scanner = new Scanner(System.in);
    }


    public void createOrderForm() {
        System.out.println("====== Форма создания заказа ======");
        System.out.print("Введите ID клиента: ");
        int nameId = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после nextInt()

        System.out.print("Введите имя клиента: ");
        String name = scanner.nextLine();

        System.out.print("Введите параметры зрения: ");
        String visionParam = scanner.nextLine();

        System.out.print("Введите ID линз: ");
        int lensesId = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после nextInt()

        System.out.print("Введите ID оправы: ");
        int frameId = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после nextInt()

        System.out.print("Введите статус заказа: ");
        String status = scanner.nextLine();

        System.out.print("Введите дату создания заказа (в формате yyyy-MM-dd): ");
        String createdAt = scanner.nextLine();

        // Создание заказа с полученными данными
        DataManager.createOrder(nameId, name, visionParam, lensesId, frameId, status, createdAt);
    }
    public void deleteOrderForm() {
        System.out.println("====== Форма удаления заказа ======");
        System.out.print("Введите ID заказа для удаления: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Очищаем буфер после nextInt()

        // Удаление заказа с указанным ID
        DataManager.deleteOrder(orderId);
    }

    public void getAllProductsForm() {
    }
}
