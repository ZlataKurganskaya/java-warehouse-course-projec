package src.main.parameter;

import src.main.entity.Spoon;

import java.security.InvalidParameterException;


public record IdSpoonParameter(int id) implements Parameter<Spoon> {
    public IdSpoonParameter {
        if (id<0) {
            throw new InvalidParameterException("Id can't be less than 0");
        }
    }

    @Override
    public boolean test(Spoon spoon) {
        return spoon.getId()==id;
    }
}