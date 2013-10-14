package ru.unn.agile.geometry;



public class IntersectionComputer {
    public IntersectionComputer() {

    }

    public Point compute(Plain plain, Line line) {
        if (plain == null && line != null) {
            throw new RuntimeException("Null plain passed");
        }
        if (plain != null && line == null) {
            throw new RuntimeException("Null line passed");
        }
        if (plain == null && line == null) {
            throw new RuntimeException("Null plain and line passed");
        }
        return null;
    }
}
