package src.main.criteria;

import src.main.entity.Product;
import src.main.parameter.Parameter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Product> implements SearchCriteria<A> {

    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(A product) {
        for (Parameter<A> parameter : parameters.values()) {
            if (!parameter.test(product)) {
                return false;
            }
        }

        return true;
    }
}