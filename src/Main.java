package src;


import src.main.controllers.*;
import src.main.service.ProductService;
import src.main.service.ServiceFactory;

import java.util.Scanner;

public class Main {

    private static final Controllers controller = new ControllersImpl();
    private static final ProductService productService = ServiceFactory.INSTANCE.getApplianceService();

    private static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.println("Hello! This is Tableware and Household Goods Warehouse app");
        System.out.println("Creator of this application is Kurganskaya Zlata. My email is zlata_kurganskaya@student.itpu.uz");
        System.out.println("Creation of this app started March 5. End date _____");

        boolean isWorking = true;
        while (isWorking) {
            System.out.println(" \n Available commands: \n 1. See all products \n 2. Search by category \n 3. Exit \n");
            System.out.println("Please enter number");
            int count = scanner.nextInt();
            switch (count) {
                case 1:
                    controller.findAll();
                    System.out.println();
                    break;
                case 2: searchByCategory(); break;
                case 3:
                    System.out.println("App is closing. Goodbye!");
                    isWorking = false;
                    break;
                default:
                    System.out.println("Wrong entry! Please choose number between 1-3 \n");
                    break;
            }
        }
    }
        public static void searchByCategory() {
            System.out.println("Choose category. \n 1.Cups \n 2.Plates \n 3.Spoons \n");
            System.out.println("Please enter number");
            int count = scanner.nextInt();
            switch (count) {
                case 1: new CupSearchMenu(scanner, productService).search(); break;
                case 2: new PlateSearchMenu(scanner, productService).search(); break;
                case 3: new SpoonSearchMenu(scanner, productService).search(); break;
                default:
                    System.out.println("Please enter number between 1-3 \n");
                    break;
            }
        }
}

