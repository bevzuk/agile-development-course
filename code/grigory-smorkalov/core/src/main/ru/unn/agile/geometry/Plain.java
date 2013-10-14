package ru.unn.agile.geometry;

/**
 * Created with IntelliJ IDEA.
 * User: geser
 * Date: 14.10.13
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class Plain {
    private Point point;
    private Point normal;

    public Plain(Point point, Point normal) {
        this.point = point;
        this.normal = normal;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getNormal() {
        return normal;
    }

    public void setNormal(Point normal) {
        this.normal = normal;
    }
}
