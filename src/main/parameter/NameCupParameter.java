package src.main.parameter;

import src.main.entity.Cup;
import src.main.entity.Product;

import java.security.InvalidParameterException;

public record NameCupParameter(String name) implements Parameter<Cup> {
    public NameCupParameter {
        if (name == null || name.isBlank()) {
            throw new InvalidParameterException("Name can't be empty");
        }
    }

    @Override
    public boolean test(Cup cup) {
        return cup.getName().equals(name);
    }
}
