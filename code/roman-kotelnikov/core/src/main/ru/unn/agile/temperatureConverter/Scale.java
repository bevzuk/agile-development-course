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
    private double _scale;
    private double _shift;

    public Scale(String name, double scale, double shift) {
        this.name = name;
        this._scale = scale;
        this._shift = shift;
    }

    public String getName() {
        return name;
    }

    public double scaleForward(double value) {
        return _scale*value + _shift;
    }

    public double scaleBackward(double value) {
        return (value - _shift) / _scale;
    }
}
