package src.main.controllers;


import src.main.controllers.SearchMenu;
import src.main.criteria.SearchCriteria;
import src.main.criteria.SpoonSearchCriteria;
import src.main.entity.Spoon;
import src.main.parameter.spoon.*;
import src.main.service.ProductService;

import java.util.Collection;
import java.util.Scanner;

public class SpoonSearchMenu implements SearchMenu {
    private final Scanner sc;
    private final ProductService service;

    public SpoonSearchMenu(Scanner sc, ProductService service) {
        this.sc = sc;
        this.service = service;
    }

    @Override
    public void search() {
        boolean correctOption;
        SearchCriteria<Spoon> spoonSearchCriteria = null;
        do {
            System.out.println("Search by: \n1. ID\n2. Price\n3. Name\n4. Color\n5. Material");
            int counter = sc.nextInt();
            spoonSearchCriteria = new SpoonSearchCriteria();
            switch (counter) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    spoonSearchCriteria.add(new IdSpoonParameter(id));
                    correctOption = true;
                    break;

                case 2:
                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();
                    spoonSearchCriteria.add(new PriceSpoonParameter(price));
                    correctOption = true;
                    break;

                case 3:
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    spoonSearchCriteria.add(new NameSpoonParameter(name));
                    correctOption = true;
                    break;

                case 4:
                    System.out.println("Enter Color:");
                    String color = sc.next();
                    spoonSearchCriteria.add(new ColorSpoonParameter(color));
                    correctOption = true;
                    break;

                case 5:
                    System.out.println("Enter Material:");
                    String material = sc.next();
                    spoonSearchCriteria.add(new MaterialParameter(material));
                    correctOption = true;
                    break;


                default:
                    System.out.println("Error! Choose the correct option.");
                    correctOption = false;
            }
        } while (!correctOption);

        Collection<Spoon> spoons = service.find(spoonSearchCriteria);
        for (Spoon spoon : spoons) {
            System.out.println(spoon);
        }
    }
}
