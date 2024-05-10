package src.main.parameter.plate;

import src.main.entity.Plate;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record SizeParameter(String size) implements Parameter<Plate> {
    public SizeParameter {
        if (size == null || size.isBlank()) {
            throw new InvalidParameterException("Size can't be empty");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getSize().equals(size);
    }
}

