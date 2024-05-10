package src.main.parameter.plate;

import src.main.entity.Plate;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record PricePlateParameter(double price) implements Parameter<Plate> {
    public PricePlateParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than zero");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getPrice() == price;
    }
}