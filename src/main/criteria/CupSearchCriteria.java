package src.main.criteria;

import src.main.entity.Cup;

public class CupSearchCriteria extends AbstractCriteria<Cup> {
    @Override
    public Class<Cup> getApplianceType() {
        return Cup.class;
    }
}

