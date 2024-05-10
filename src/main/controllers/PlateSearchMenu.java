package src.main.controllers;

import src.main.criteria.PlateSearchCriteria;
import src.main.criteria.SearchCriteria;
import src.main.entity.Plate;
import src.main.parameter.plate.*;
import src.main.service.ProductService;

import java.util.Collection;
import java.util.Scanner;

public class PlateSearchMenu implements SearchMenu {
    private final Scanner sc;
    private final ProductService service;

    public PlateSearchMenu(Scanner sc, ProductService service) {
        this.sc = sc;
        this.service = service;
    }

    @Override
    public void search() {
        boolean correctOption;
        SearchCriteria<Plate> plateSearchCriteria = null;
        do {
            System.out.println("Search by: \n1. ID\n2. Price\n3. Name\n4. Color\n5. Volume");
            int counter = sc.nextInt();
            plateSearchCriteria = new PlateSearchCriteria();
            switch (counter) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    plateSearchCriteria.add(new IdPlateParameter(id));
                    correctOption = true;
                    break;

                case 2:
                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();
                    plateSearchCriteria.add(new PricePlateParameter(price));
                    correctOption = true;
                    break;

                case 3:
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    plateSearchCriteria.add(new NamePlateParameter(name));
                    correctOption = true;
                    break;

                case 4:
                    System.out.println("Enter Color:");
                    String color = sc.next();
                    plateSearchCriteria.add(new ColorPlateParameter(color));
                    correctOption = true;
                    break;

                case 5:
                    System.out.println("Enter Size:");
                    String size = sc.next();
                    plateSearchCriteria.add(new SizeParameter(size));
                    correctOption = true;
                    break;

                default:
                    System.out.println("Error! Choose the correct option.");
                    correctOption = false;
            }
        } while (!correctOption);

        Collection<Plate> plates = service.find(plateSearchCriteria);
        for (Plate plate : plates) {
            System.out.println(plate);
        }
    }
}