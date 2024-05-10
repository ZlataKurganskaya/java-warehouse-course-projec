package src.main.parameter.spoon;

import src.main.entity.Product;
import src.main.entity.Spoon;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record PriceSpoonParameter(double price) implements Parameter<Spoon> {
    public PriceSpoonParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than zero");
        }
    }

    @Override
    public boolean test(Spoon spoon) {
        return spoon.getPrice() == price;
    }
}