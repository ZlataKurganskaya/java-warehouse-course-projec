package src.main.search;

import src.main.entity.Product;

import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVFileManager {
    private static final String CSV_FILE_PATH = "src/main/resources/products.csv";

    public static void writeProductToCSV(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH), true)) {
            writer.write(product.getId() + "," + product.getPrice() + "," + product.getName() + "," + product.getColor());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readProductCSV() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                double price = Double.parseDouble(data[1]);
                String name = data[2];
                String color = data[3];
                Product product = new Product(id, price, name, color);
                products.add(product);
            }
        }
            catch(IOException e){
                e.printStackTrace();
            }
            return products;
        }
    }



