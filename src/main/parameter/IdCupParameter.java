package src.main.parameter;

import src.main.entity.Cup;

import java.security.InvalidParameterException;


public record IdCupParameter(int id) implements Parameter<Cup> {
    public IdCupParameter {
        if (id<0) {
            throw new InvalidParameterException("Id can't be less than 0");
        }
    }

    @Override
    public boolean test(Cup cup) {
        return cup.getId() == id;
    }
}