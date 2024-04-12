package src.main.criteria;

import src.main.entity.Product;
import src.main.parameter.Parameter;

public interface SearchCriteria<A extends Product> {
    Class<A> getApplianceType();
    <P extends Parameter<A>> SearchCriteria<A> add(P parameter);
    boolean test(A appliance);
}

