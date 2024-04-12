package src.main.parameter;

import src.main.entity.Plate;
import src.main.entity.Product;

import java.security.InvalidParameterException;

public record ColorPlateParameter(String color) implements Parameter<Plate> {
    public ColorPlateParameter {
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("Color can't be none");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getColor().equals(color);
    }
}