package src.main.parameter;

import src.main.entity.Plate;

import java.security.InvalidParameterException;


public record IdPlateParameter(int id) implements Parameter<Plate> {
    public IdPlateParameter {
        if (id<0) {
            throw new InvalidParameterException("Id can't be less than 0");
        }
    }

    @Override
    public boolean test(Plate plate) {
        return plate.getId()==id;
    }
}