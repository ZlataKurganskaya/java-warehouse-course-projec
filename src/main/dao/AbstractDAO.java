package src.main.dao;

import src.main.criteria.SearchCriteria;
import src.main.entity.Product;
import src.main.parser.CsvLineParser;

import java.nio.file.Path;
import java.util.Collection;

public abstract class AbstractDAO<A extends Product> implements ProductDAO<A> {
    private final String csvPath;
    private final CsvLineParser<A> parser;



    protected AbstractDAO(String path, CsvLineParser<A> parser) {
        this.csvPath = path;
        this.parser = parser;
    }

    @Override
    public Collection<A> findAll() {
        return parser.parse(csvPath);
    }

    @Override
    public Collection<A> find(SearchCriteria<A> criteria) {
        return parser.parse(csvPath).stream().filter(criteria::test).toList();
    }
}