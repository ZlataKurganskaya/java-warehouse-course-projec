package src.main.parameter;

import src.main.entity.Plate;
import src.main.entity.Product;

import java.security.InvalidParameterException;

public record NamePlateParameter(String name) implements Parameter<Plate> {
    public NamePlateParameter {
        if (name == null || name.isBlank()) {
            throw new InvalidParameterException("Name can't be empty");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getName().equals(name);
    }
}