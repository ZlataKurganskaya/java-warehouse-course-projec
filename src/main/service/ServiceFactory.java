package src.main.service;


import src.main.criteria.CupSearchCriteria;
import src.main.criteria.PlateSearchCriteria;
import src.main.criteria.SearchCriteria;
import src.main.criteria.SpoonSearchCriteria;
import src.main.dao.DaoFactory;
import src.main.entity.Cup;
import src.main.entity.Plate;
import src.main.entity.Product;
import src.main.entity.Spoon;

import java.util.Collection;
import java.util.Objects;

public enum ServiceFactory {
    INSTANCE;

    public ProductService getApplianceService() {
        return new ProductService() {

            private final SearchCriteria<Cup> cupClass = new CupSearchCriteria();
            private final SearchCriteria<Plate> plateClass = new PlateSearchCriteria();
            private final SearchCriteria<Spoon> spoonClass = new SpoonSearchCriteria();

            @Override
            public <A extends Product> Collection<A> find(SearchCriteria<A> criteria) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(criteria.getApplianceType()))
                        .find(criteria);
            }


            @Override
            public <A extends Product> Collection<A> findAll(Class<A> classType) {
                return Objects.requireNonNull(DaoFactory.INSTANCE.getApplianceDAO(classType))
                        .findAll();
            }
        };
    }
}
