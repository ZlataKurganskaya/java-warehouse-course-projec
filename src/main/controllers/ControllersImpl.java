package src.main.controllers;

import src.main.criteria.CupSearchCriteria;
import src.main.criteria.PlateSearchCriteria;
import src.main.criteria.SpoonSearchCriteria;
import src.main.entity.Cup;
import src.main.entity.Plate;
import src.main.entity.Product;
import src.main.entity.Spoon;
import src.main.service.ProductService;
import src.main.service.ServiceFactory;

import java.util.Collection;

public class ControllersImpl  implements Controllers{

@Override
    public void findAll() {
    ProductService service = ServiceFactory.INSTANCE.getApplianceService();
    Collection<Cup> cups = service.find(new CupSearchCriteria());
    for (Cup cup : cups ) {
        System.out.println(cup);
    }

    Collection<Spoon> spoons = service.find(new SpoonSearchCriteria());
    for (Spoon spoon : spoons ) {
        System.out.println(spoon);
    }

    Collection<Plate> plates = service.find(new PlateSearchCriteria());
    for (Plate plate : plates ) {
        System.out.println(plate);
    }
}
}
