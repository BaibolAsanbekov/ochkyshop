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

        System.out.println("Форма добавления новой оправы");
        System.out.print("Введите название оправы: ");
        String name = scanner.nextLine();
        System.out.print("Введите описание оправы: ");
        String description = scanner.nextLine();

        boolean success = DataManager.addFrame(name, description);
        if (success) {
            System.out.println("Товар успешно добавлен.");
        } else {
            System.out.println("Ошибка при добавлении товара.");
        }
    }
    public void createOrderLenses() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Форма добавления новой линзы");
        System.out.print("Введите название линзы: ");
        String name = scanner.nextLine();
        System.out.print("Введите описание линзы: ");
        String description = scanner.nextLine();

        boolean success = DataManager.addLenses(name, description);
        if (success) {
            System.out.println("Товар успешно добавлен.");
        } else {
            System.out.println("Ошибка при добавлении товара.");
        }
    }

}
