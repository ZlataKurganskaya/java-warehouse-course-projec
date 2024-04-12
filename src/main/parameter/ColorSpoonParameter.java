package src.main.parameter;

import src.main.entity.Product;
import src.main.entity.Spoon;

import java.security.InvalidParameterException;


public record ColorSpoonParameter(String color) implements Parameter<Spoon> {
    public ColorSpoonParameter {
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("Color can't be none");
        }
    }

    @Override
    public boolean test(Spoon spoon) {
        return spoon.getColor().equals(color);
    }
}
