package src.main.parameter.cup;

import src.main.entity.Cup;
import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record ColorCupParameter(String color) implements Parameter<Cup> {
    public ColorCupParameter {
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("Color can't be none");
        }
    }

    @Override
    public boolean test(Cup cup) {
        return cup.getColor().equals(color);
    }
}