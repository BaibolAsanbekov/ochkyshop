package ProductManagment;
import DataManager.DataManager;
import java.util.Scanner;

public class product_form {
    private final Scanner scanner;

    public product_form() {
        this.scanner = new Scanner(System.in);
    }
    public void createOrderFrame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Form for adding a new frame");
        System.out.print("Enter the name of the frame: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description of the frame: ");
        String description = scanner.nextLine();

        boolean success = DataManager.addFrame(name, description);
        if (success) {
            System.out.println("Product has been successfully added.");
        } else {
            System.out.println("Error when adding a product.");
        }
    }
    public void createOrderLenses() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Form for adding a new lens");
        System.out.print("Enter the name of the lens: ");
        String name = scanner.nextLine();
        System.out.print("Enter a description of the lens: ");
        String description = scanner.nextLine();

        boolean success = DataManager.addLenses(name, description);
        if (success) {
            System.out.println("Product has been successfully added.");
        } else {
            System.out.println("Error when adding a product.");
        }
    }

}