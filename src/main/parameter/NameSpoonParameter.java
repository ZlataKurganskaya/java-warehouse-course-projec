package src.main.parameter;

import src.main.entity.Product;
import src.main.entity.Spoon;

import java.security.InvalidParameterException;

public record NameSpoonParameter(String name) implements Parameter<Spoon> {
    public NameSpoonParameter {
        if (name == null || name.isBlank()) {
            throw new InvalidParameterException("Name can't be empty");
        }
    }

    @Override
    public boolean test(Spoon spoon) {
        return spoon.getName().equals(name);
    }
}