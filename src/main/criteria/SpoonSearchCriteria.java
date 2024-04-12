package src.main.criteria;

import src.main.entity.Cup;
import src.main.entity.Spoon;

public class SpoonSearchCriteria extends AbstractCriteria<Spoon> {
    @Override
    public Class<Spoon> getApplianceType() {
        return Spoon.class;
    }
}
