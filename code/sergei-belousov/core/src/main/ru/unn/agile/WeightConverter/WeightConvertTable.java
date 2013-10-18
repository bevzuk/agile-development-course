package ru.unn.agile.WeightConverter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WeightConvertTable {
    private HashMap<WeightKey, Double> weightConvertTable;

    public WeightConvertTable() {
        weightConvertTable = new HashMap<WeightKey, Double>();
    }

    public boolean isEmpty() {
        return weightConvertTable.isEmpty();
    }

    public void addPair(WeightKey pair, double factor) {
        weightConvertTable.put(pair, new Double(factor));
        weightConvertTable.put(pair.reverse(), new Double(1. / factor));
    }

    public double getFactor(WeightKey pair) throws WeightConvertTableException {
        if(!weightConvertTable.containsKey(pair)) {
            throw new WeightConvertTableException("key not found.");
        }
        else {
            return weightConvertTable.get(pair);
        }
    }
}
