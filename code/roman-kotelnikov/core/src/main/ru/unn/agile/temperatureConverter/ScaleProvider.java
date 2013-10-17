package ru.unn.agile.temperatureConverter;

import java.util.HashMap;

public class ScaleProvider {

    private static HashMap<ScaleFormat, Scale> availableScales;

    static {
        availableScales = new HashMap<ScaleFormat, Scale>();

        availableScales.put(ScaleFormat.Celsius, new Scale("Celsius", 1, 0));
        availableScales.put(ScaleFormat.Fahrenheit, new Scale("Fahrenheit", 9.0 / 5.0, 32));
    }

    public static Scale get(ScaleFormat scaleName) {
        return availableScales.get(scaleName);
    }
}
