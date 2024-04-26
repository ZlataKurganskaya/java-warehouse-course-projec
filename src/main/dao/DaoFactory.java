package src.main.dao;

import src.main.entity.Cup;
import src.main.entity.Plate;
import src.main.entity.Product;
import src.main.entity.Spoon;

public enum DaoFactory {
    INSTANCE;
@SuppressWarnings("uncheked")
    public <A extends Product> ProductDAO<A> getApplianceDAO(Class<A> applianceType) {
        if(Cup.class.equals(applianceType)) { return (ProductDAO<A>) new CupDAO(); }
        if(Plate.class.equals(applianceType)) { return (ProductDAO<A>) new PlateDAO(); }
        if(Spoon.class.equals(applianceType)) { return (ProductDAO<A>) new SpoonDAO(); }
        return null;
    }
}
