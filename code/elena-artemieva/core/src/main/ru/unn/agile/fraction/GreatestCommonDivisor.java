package ru.unn.agile.fraction;

public class GreatestCommonDivisor {

    public static int calculate(int first, int second) {
        return Math.abs(second == 0 ? first : calculate(second, first % second));
    }
}
