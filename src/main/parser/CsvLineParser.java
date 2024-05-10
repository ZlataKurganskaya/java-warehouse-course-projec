package src.main.parser;

import java.nio.file.Path;
import java.util.Collection;

public interface CsvLineParser <A> {
    Collection<A> parse(String path);
}
