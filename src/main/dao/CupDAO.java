package src.main.dao;

import src.main.entity.Cup;
import src.main.entity.Spoon;
import src.main.parser.CupParser;

public class CupDAO extends AbstractDAO<Cup> {
    public CupDAO() {
        super("src/main/resources/Cup.csv", new CupParser());
    }
}
