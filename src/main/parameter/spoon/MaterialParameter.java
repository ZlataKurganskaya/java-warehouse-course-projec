package src.main.parameter.spoon;

import src.main.entity.Spoon;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

    public record MaterialParameter(String material) implements Parameter<Spoon> {
        public MaterialParameter {
            if (material == null || material.isBlank()) {
                throw new InvalidParameterException("Material can't be empty");
            }
        }

        @Override
        public boolean test(Spoon spoon) {
            return spoon.getMaterial().equals(material);
        }
    }