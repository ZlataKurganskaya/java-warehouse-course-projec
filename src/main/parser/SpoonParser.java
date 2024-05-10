package src.main.parser;

import src.main.entity.Spoon;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class SpoonParser implements CsvLineParser<Spoon>{
    @Override
    public Collection<Spoon> parse(String path) {
        Collection<Spoon> collection = new LinkedList<>();
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
                String material = splitData[4].trim();
                Spoon spoon = new Spoon(id, price, name, color, material);
                collection.add(spoon);
            }
        }
        catch (IOException e) {
            throw new InvalidParameterException("File exception. This file is not available");
        }
        return collection;
    }
}
