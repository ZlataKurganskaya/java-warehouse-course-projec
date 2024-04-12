package src.main.parameter;

import src.main.entity.Product;

import java.security.InvalidParameterException;

public record ColorParameter(String color) implements Parameter<Product> {
    public ColorParameter {
        if (color == null || color.isBlank()) {
            throw new InvalidParameterException("Color can't be none");
        }
    }

    @Override
    public boolean test(Product product) {
        return product.getColor().equals(color);
    }
}