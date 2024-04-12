package src.main.dao;

import src.main.criteria.SearchCriteria;
import src.main.entity.Product;

import java.util.Collection;


public interface ProductDAO <A extends Product> {
    Collection<A> find(SearchCriteria<A> criteria);
}

