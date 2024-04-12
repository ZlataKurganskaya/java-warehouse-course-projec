package src.main.parameter;

import src.main.entity.Product;

import java.security.InvalidParameterException;

public record NameParameter(String name) implements Parameter<Product> {
    public NameParameter {
        if (name == null || name.isBlank()) {
            throw new InvalidParameterException("Name can't be empty");
        }
    }

    @Override
    public boolean test(Product product) {
        return product.getName().equals(name);
    }
}