package src.main.controllers;

import src.main.criteria.CupSearchCriteria;
import src.main.criteria.SearchCriteria;
import src.main.entity.Cup;
import src.main.parameter.cup.*;
import src.main.service.ProductService;

import java.util.Collection;
import java.util.Scanner;

public class CupSearchMenu implements SearchMenu {
    private final Scanner sc;
    private final ProductService service;

    public CupSearchMenu(Scanner sc, ProductService service) {
        this.sc = sc;
        this.service = service;
    }

    @Override
    public void search() {
        boolean correctOption;
        SearchCriteria<Cup> cupSearchCriteria = null;
        do {
            System.out.println("Search by: \n1. ID\n2. Price\n3. Name\n4. Color\n5. Volume");
            int counter = sc.nextInt();
            cupSearchCriteria = new CupSearchCriteria();
            switch (counter) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    cupSearchCriteria.add(new IdCupParameter(id));
                    correctOption = true;
                    break;

                case 2:
                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();
                    cupSearchCriteria.add(new PriceCupParameter(price));
                    correctOption = true;
                    break;

                case 3:
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    cupSearchCriteria.add(new NameCupParameter(name));
                    correctOption = true;
                    break;

                case 4:
                    System.out.println("Enter Color:");
                    String color = sc.next();
                    cupSearchCriteria.add(new ColorCupParameter(color));
                    correctOption = true;
                    break;

                case 5:
                    System.out.println("Enter Volume:");
                    int volume = sc.nextInt();
                    cupSearchCriteria.add(new VolumeParameter(volume));
                    correctOption = true;
                    break;

                default:
                    System.out.println("Error! Choose the correct option.");
                    correctOption = false;
            }
        } while (!correctOption);

        Collection<Cup> cups = service.find(cupSearchCriteria);
        for (Cup cup : cups) {
            System.out.println(cup);
        }
    }
}