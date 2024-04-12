package src.main.criteria;

import src.main.entity.Cup;
import src.main.entity.Plate;

public class PlateSearchCriteria extends AbstractCriteria<Plate> {
    @Override
    public Class<Plate> getApplianceType() {
        return Plate.class;
    }
}
