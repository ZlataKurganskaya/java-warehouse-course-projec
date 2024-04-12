package src.main.parameter;

import src.main.entity.Spoon;

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