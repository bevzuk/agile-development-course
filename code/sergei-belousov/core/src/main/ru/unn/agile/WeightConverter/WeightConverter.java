package ru.unn.agile.WeightConverter;

import ru.unn.agile.UnitConverter.Unit;
import ru.unn.agile.UnitConverter.UnitConvertTableException;
import ru.unn.agile.UnitConverter.UnitConverter;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.lang.String;

public class WeightConverter {
    private UnitConverter weightConverter;

    public WeightConverter() {
        weightConverter = new UnitConverter();
    }

    public boolean isEmpty() {
        return weightConverter.isEmpty();
    }

    public void loadTable(String path) throws IOException {
        try {
            Scanner in = new Scanner(new File(path));
            while(in.hasNext()) {
                try {
                    String[] tokens = split(in.nextLine());
                    weightConverter.addPair(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
                } catch(WeightConverterException e) {
                    System.out.println(e.getMessage());
                }
            }
            in.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public Unit convert(String fromToFormatString, Unit value) throws UnitConvertTableException{
        try{
            return weightConverter.convert(fromToFormatString, value);
        }catch(UnitConvertTableException e){
            throw e;
        }
    }

    private String[] split(String formatString) throws WeightConverterException {
        String[] tokens = formatString.split(" ");
        if(tokens.length == 3) {
            return tokens;
        }
        else {
            throw new WeightConverterException("invalid format string");
        }
    }
}