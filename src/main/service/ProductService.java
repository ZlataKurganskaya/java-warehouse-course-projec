package src.main.service;

import src.main.criteria.SearchCriteria;
import src.main.entity.Product;

import java.util.Collection;

public interface ProductService {
    <A extends Product> Collection<A> find(SearchCriteria<A> criteria);

    <A extends Product> Collection<A> findAll(Class<A> classType);
}