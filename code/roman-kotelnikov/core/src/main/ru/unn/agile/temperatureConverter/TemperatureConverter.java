package ru.unn.agile.temperatureConverter;

public class TemperatureConverter {
    private double current;
    private static final double kelvinConstant = 273.15;

    public TemperatureConverter() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public TemperatureConverter(double celsius) {
        this.current = celsius;
    }

    public void setCurrentInCelsius(double currentInCelsius) {
        this.current = currentInCelsius;
    }

    public double getCurrentInCelsius() {
        return current;
    }

    public void setCurrentInFahrenheit(double currentInFahrenheit) {
        this.current = (currentInFahrenheit - 32) * 5.0 / 9.0;
    }

    public double getCurrentInFahrenheit() {
        return current * 9.0 / 5.0 + 32;
    }

    public void setCurrentInKelvin(double kelvin) {
        this.current = kelvin - kelvinConstant;
    }

    public double getCurrentInKelvin() {
        return current + kelvinConstant;
    }

    public void setCurrentInNewton(double newton) {
        this.current = newton * 100.0 / 33.0;
    }

    public double getCurrentInNewton() {
        return current * 33.0 / 100.0;
    }
}