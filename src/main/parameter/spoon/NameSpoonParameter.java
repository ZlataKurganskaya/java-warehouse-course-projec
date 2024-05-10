package src.main.parameter.spoon;

import src.main.entity.Product;
import src.main.entity.Spoon;
import src.main.parameter.Parameter;

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