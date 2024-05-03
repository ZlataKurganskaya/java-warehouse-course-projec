package src.main.search;

import src.main.entity.Product;
import src.main.search.CSVFileManager;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static void createProduct(int id, double price, String name,String color) {
        List<Product> products = CSVFileManager.readProductCSV();
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean idExist = false;
            boolean nameExist = false;

            for (Product product : products) {
                if (product.getId() == id) {
                    System.out.println("Product with id" +id + "exist. Please enter another id ");
                    id = sc.nextInt();
                    sc.nextLine();
                    idExist = true;
                }

            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Product with name" + name + "exist. Please enter another name");
                name = sc.nextLine();
                nameExist = true;
            }
            }
            if (!idExist && !nameExist) {
                break;
            }
        }
        Product product = new Product(id, price, name, color);
        CSVFileManager.writeProductToCSV(product);
        System.out.println("Product created");
    }

    public static Product searchProduct(String name) {
        List<Product> products = CSVFileManager.readProductCSV();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

}
