package src.main.parameter.cup;

import src.main.entity.Cup;
import src.main.parameter.Parameter;

import java.security.InvalidParameterException;

public record VolumeParameter(int volume) implements Parameter<Cup> {
        public VolumeParameter {
            if (volume <0) {
                throw new InvalidParameterException("Volume can't be less than zero");
            }
        }

        @Override
        public boolean test(Cup cup) {
            return cup.getVolume() == volume;
        }
    }