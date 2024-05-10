package src.main.parameter.cup;

import src.main.entity.Cup;
import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record PriceCupParameter(double price) implements Parameter<Cup> {
    public PriceCupParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than zero");
        }
    }

    @Override
    public boolean test(Cup cup) {
        return cup.getPrice() == price;
    }
}