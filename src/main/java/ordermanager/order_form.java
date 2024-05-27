package ordermanager;

import DataManager.DataManager;

import java.util.Scanner;

public class order_form {
    private final Scanner scanner;

    public order_form() {
        this.scanner = new Scanner(System.in);
    }


    public void createOrderForm() {
        System.out.println("====== Order creation form ======");
        System.out.print("Enter the customer ID: ");
        int nameId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the client's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the vision parameters: ");
        String visionParam = scanner.nextLine();

        System.out.print("Enter the lens ID: ");
        int lensesId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the frame ID: ");
        int frameId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the status of the order: ");
        String status = scanner.nextLine();

        System.out.print("Enter the date the order was created  (in the format of yyyy-MM-dd): ");
        String createdAt = scanner.nextLine();


        DataManager.createOrder(nameId, name, visionParam, lensesId, frameId, status, createdAt);
    }
    public void deleteOrderForm() {
        System.out.println("====== Order deletion form ======");
        System.out.print("Enter the order ID to delete: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();


        DataManager.deleteOrder(orderId);
    }

    public void getAllProductsForm() {
    }
    public static void updateOrderStatusForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Form for changing the order status");
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        System.out.print("Enter a new order status: ");
        String newStatus = scanner.nextLine();

        DataManager.updateOrderStatus(orderId, newStatus);
    }
    public void addOrderClient() {
        System.out.println("====== Order creation form ======");
        System.out.print("Enter the customer ID: ");
        int nameId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the client's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the vision parameters: ");
        String visionParam = scanner.nextLine();

        System.out.print("Enter the lens ID: ");
        int lensesId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the frame ID: ");
        int frameId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the date the order was created (in the format of yyyy-MM-dd): ");
        String createdAt = scanner.nextLine();

        DataManager.addOrderClient(nameId, name, visionParam, lensesId, frameId,createdAt);
    }
}