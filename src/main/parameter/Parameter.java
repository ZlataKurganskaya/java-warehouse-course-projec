package src.main.parameter;

import src.main.entity.Product;

public interface Parameter<A extends Product> {
    boolean test(A appliance);
}