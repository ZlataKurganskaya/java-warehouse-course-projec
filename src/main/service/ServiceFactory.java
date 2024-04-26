package src.main.service;


import src.main.criteria.SearchCriteria;
import src.main.dao.DaoFactory;
import src.main.entity.Product;

import java.util.Collection;
import java.util.Objects;

public enum ServiceFactory {
    INSTANCE;

    public ProductService getApplianceService() {
        return new ProductService() {
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
