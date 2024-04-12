package src.main.dao;

import src.main.criteria.SearchCriteria;
import src.main.entity.Product;
import src.main.parser.CsvLineParser;

import java.nio.file.Path;
import java.util.Collection;

public abstract class AbstractDAO<A extends Product> implements ProductDAO<A> {
    private final Path csvPath;
    private final CsvLineParser<A> parser;



    protected AbstractDAO(String path, CsvLineParser<A> parser) {
        this.csvPath = Path.of(path);
        this.parser = parser;
    }

    @Override
    public Collection<A> find(SearchCriteria<A> criteria) {
        return null;
    }
}