package src.main.parameter;

import src.main.entity.Product;

import java.security.InvalidParameterException;

public record IdParameter(int id) implements Parameter<Product> {
    public IdParameter {
        if (id<0) {
            throw new InvalidParameterException("Id can't be less than 0");
        }
    }

    @Override
    public boolean test(Product product) {
        return product.getId()==id;
    }
}