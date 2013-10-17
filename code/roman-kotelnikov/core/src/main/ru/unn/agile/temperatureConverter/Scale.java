package ru.unn.agile.temperatureConverter;

/**
 * Created with IntelliJ IDEA.
 * User: zak
 * Date: 16.10.13
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class Scale {
    private String name;
    private double multiplier;
    private double shift;

    public Scale(String name, double multiplier, double shift) throws IllegalArgumentException {
        if(name == null)
            throw new IllegalArgumentException("Scale name cannot be null");

        this.name = name;
        this.multiplier = multiplier;
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public double scaleForward(double value) {
        return multiplier *value + shift;
    }

    public double scaleBackward(double value) {
        return (value - shift) / multiplier;
    }
}
