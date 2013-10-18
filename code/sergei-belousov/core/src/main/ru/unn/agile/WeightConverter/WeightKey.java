package ru.unn.agile.WeightConverter;

public class WeightKey {
    private final String from;
    private final String to;

    public WeightKey(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public WeightKey reverse() {
        return new WeightKey(to, from);
    }

    public String toString() {
        return from + "-" + to;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WeightKey)) return false;
        WeightKey key = (WeightKey) obj;
        return from.equals(key.from) && to.equals(key.to);
    }

    @Override
    public int hashCode() {
        return new String(from + "-" + to).hashCode();
    }
}
