package src.main.dao;

import src.main.entity.Plate;
import src.main.entity.Spoon;
import src.main.parser.PlateParser;

public class PlateDAO extends AbstractDAO<Plate> {
    public PlateDAO() {
        super("src/main/resources/Plate.csv", new PlateParser());
    }
}
