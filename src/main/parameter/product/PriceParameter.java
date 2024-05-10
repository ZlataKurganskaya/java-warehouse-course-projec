package src.main.parameter.product;

import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;


public record PriceParameter(double price) implements Parameter<Product> {
    public PriceParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than zero");
        }
    }

    @Override
    public boolean test(Product product) {
        return product.getPrice() == price;
    }
}