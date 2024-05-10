package src.main.parser;



import src.main.entity.Cup;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;


public class CupParser implements CsvLineParser<Cup> {

    @Override
    public Collection<Cup> parse(String path) {
        Collection<Cup> collection = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitData = line.split(",");
                if (splitData.length != 5) {
                    System.err.println("Warning: Skipped line due to wrong data format: " + line);
                    continue;
                }
                int id = Integer.parseInt(splitData[0].trim());
                double price = Double.parseDouble(splitData[1].trim());
                String name = splitData[2].trim();
                String color = splitData[3].trim();
                int volume = Integer.parseInt(splitData[4].trim());
                Cup cup = new Cup(id, price, name, color, volume );
                collection.add(cup);
            }
        }
            catch (IOException e) {
            throw new InvalidParameterException("File exception. This file is not available");
            }
        return collection;
        }
    }
