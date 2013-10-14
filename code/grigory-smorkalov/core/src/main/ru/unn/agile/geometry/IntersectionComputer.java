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

        Point linePlainPointsDiff = line.getPoint().minus(plain.getPoint());
        double distance = plain.getNormal().scalarMultiply(linePlainPointsDiff);

        if (Math.abs(plain.getNormal().scalarMultiply(line.getDirection())) < Point.ACCURACY) {
            if (Math.abs(distance) < Point.ACCURACY) {
                return line.getPoint();
            } else {
                return null;
            }
        } else {
            return plain.getPoint();
        }

    }
}
