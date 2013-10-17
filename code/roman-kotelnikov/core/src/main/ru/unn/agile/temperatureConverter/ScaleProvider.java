package ru.unn.agile.temperatureConverter;

import java.util.HashMap;

public class ScaleProvider {

    private static HashMap<AvailableScales, Scale> availableScales;
    private static double kelvinConstant = 273.15;

    static {
        try {
            availableScales = new HashMap<AvailableScales, Scale>();

            availableScales.put(AvailableScales.Celsius, new Scale("Celsius", 1, 0));
            availableScales.put(AvailableScales.Fahrenheit, new Scale("Fahrenheit", 9.0 / 5.0, 32));
            availableScales.put(AvailableScales.Kelvin, new Scale("Kelvin", 1, kelvinConstant));
            availableScales.put(AvailableScales.Newton, new Scale("Newton", 33.0 / 100.0, 0));
            availableScales.put(AvailableScales.Rankine, new Scale("Rankine", 9.0 / 5.0, kelvinConstant * 9.0 / 5.0));
            availableScales.put(AvailableScales.Delisle, new Scale("Delisle", -3.0/2.0, -100*3.0/2.0));
            availableScales.put(AvailableScales.Reaumur, new Scale("Réaumur", 4.0/5.0, 0));
            availableScales.put(AvailableScales.Romer, new Scale("Rømer", 21.0/40.0, 7.5));
        }
        catch (Exception e) {
            //newer happens if tests are OK
        }
    }

    public static Scale get(AvailableScales scaleName) {
        if(availableScales.containsKey(scaleName))
            return availableScales.get(scaleName);
        else
            throw new IllegalArgumentException("Scale doesn't exists");
    }
}
