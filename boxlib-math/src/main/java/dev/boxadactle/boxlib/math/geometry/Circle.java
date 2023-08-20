package dev.boxadactle.boxlib.math.geometry;

import dev.boxadactle.boxlib.math.mathutils.BMath;

@SuppressWarnings("unchecked")
public class Circle<T extends Number> {
    private T radius;

    public Circle(T radius) {
        this.radius = radius;
    }

    public T getRadius() {
        return radius;
    }

    public T getArea() {
        double radiusValue = radius.doubleValue();
        return (T) Double.valueOf(BMath.PI * radiusValue * radiusValue);
    }

    public T getCircumference() {
        return (T) Double.valueOf(2 * BMath.PI * radius.doubleValue());
    }

    public boolean intersects(Circle<T> otherCircle) {
        double distanceBetweenCenters = (double) calculateDistance(this, otherCircle);
        double combinedRadii = this.radius.doubleValue() + otherCircle.getRadius().doubleValue();
        return distanceBetweenCenters <= combinedRadii;
    }

    private T calculateDistance(Circle<T> circle1, Circle<T> circle2) {
        // Calculate the Euclidean distance between the centers of the two circles
        double x1 = 0;  // Assuming the circles are centered at the origin
        double y1 = 0;
        double x2 = circle2.getRadius().doubleValue();
        double y2 = 0;
        return (T) Double.valueOf(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
    }
}