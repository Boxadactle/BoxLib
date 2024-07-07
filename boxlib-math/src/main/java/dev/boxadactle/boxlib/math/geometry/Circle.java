package dev.boxadactle.boxlib.math.geometry;

import dev.boxadactle.boxlib.math.mathutils.BMath;

@SuppressWarnings("unchecked")
/**
 * Represents a circle in a two-dimensional space.
 *
 * @param <T> the type of the radius (must extend Number)
 */
public class Circle<T extends Number> {
    private T radius;

    /**
     * Constructs a circle with the specified radius.
     *
     * @param radius the radius of the circle
     */
    public Circle(T radius) {
        this.radius = radius;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public T getRadius() {
        return radius;
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return the area of the circle
     */
    public T getArea() {
        double radiusValue = radius.doubleValue();
        return (T) Double.valueOf(BMath.PI * radiusValue * radiusValue);
    }

    /**
     * Calculates and returns the circumference of the circle.
     *
     * @return the circumference of the circle
     */
    public T getCircumference() {
        return (T) Double.valueOf(2 * BMath.PI * radius.doubleValue());
    }

    /**
     * Checks if this circle intersects with another circle.
     *
     * @param otherCircle the other circle to check for intersection
     * @return true if the circles intersect, false otherwise
     */
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

    @Override
    protected Circle<T> clone() {
        return new Circle<>(radius);
    }
}