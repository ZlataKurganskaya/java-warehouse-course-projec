package src.main.parser;
import src.main.entity.Cup;
import src.main.entity.Plate;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class PlateParser implements CsvLineParser<Plate>{
    @Override
public Collection<Plate> parse(String path) {
    Collection<Plate> collection = new LinkedList<>();
    try (Scanner scanner = new Scanner(new File(path))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitData = line.split(",");
            if (splitData.length != 5) {
                throw new IllegalArgumentException("Wrong data format");
            }
            int id = Integer.parseInt(splitData[0].trim());
            double price = Double.parseDouble(splitData[1].trim());
            String name = splitData[2].trim();
            String color = splitData[3].trim();
            String size = splitData[4].trim();
            Plate plate = new Plate(id, price, name, color, size);
            collection.add(plate);
        }
    }
    catch (IOException e) {
        throw new InvalidParameterException("File exception. This file is not available");
    }
    return collection;
}
}
