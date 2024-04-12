package src.main.parameter;

import src.main.entity.Plate;
import src.main.entity.Product;

import java.security.InvalidParameterException;

public record PlatePriceParameter(double price) implements Parameter<Plate> {
    public PlatePriceParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than zero");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getPrice() == price;
    }
}