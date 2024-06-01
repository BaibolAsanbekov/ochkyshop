package org.example;

import authentication.Authentication;
import ordermanager.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication(scanner);

        while (true) {
            System.out.println("Welcome to the optical salon!");
            System.out.println("Choose a role:");
            System.out.println("1. Log in as Administrator");
            System.out.println("2. Register as a Client");
            System.out.println("3. Sign in as a Customer");
            System.out.println("4. Exit");
            System.out.print("Your action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    authentication.authenticateAdmin();
                    adminMenu.adminMenu();
                    break;
                case 2:
                    authentication.registerUser();
                    authentication.authenticateUser();
                    break;
                case 3:
                    authentication.authenticateUser();
                    clientMenu.clientMenu();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Please select the correct option.");
            }
        }
    }
}