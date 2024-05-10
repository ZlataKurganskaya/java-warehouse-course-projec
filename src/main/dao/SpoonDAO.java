package src.main.dao;

import src.main.entity.Spoon;
import src.main.parser.SpoonParser;

public class SpoonDAO extends AbstractDAO<Spoon>{
    public SpoonDAO(){
        super("src/main/resources/Spoon.csv", new SpoonParser());
    }
}
