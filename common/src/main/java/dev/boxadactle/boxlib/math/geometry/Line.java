package dev.boxadactle.boxlib.math.geometry;

@SuppressWarnings("unchecked")
public class Line<T extends Number> {
    private T slope;
    private T yIntercept;

    public Line(T slope, T yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    public T getSlope() {
        return slope;
    }

    public T getYIntercept() {
        return yIntercept;
    }

    public boolean intersects(Line<T> otherLine) {
        // Check if the two lines are not parallel
        return !this.slope.equals(otherLine.getSlope());
    }

    public T intersectionX(Line<T> otherLine) {
        if (!intersects(otherLine)) {
            throw new IllegalArgumentException("Lines are parallel and do not intersect.");
        }

        // Calculate the x-coordinate of the intersection point
        return (T) Double.valueOf(
                ((Double) otherLine.getYIntercept() - (Double) this.yIntercept) /
                        ((Double) this.slope - (Double) otherLine.getSlope())
        );
    }

    public T intersectionY(Line<T> otherLine) {
        if (!intersects(otherLine)) {
            throw new IllegalArgumentException("Lines are parallel and do not intersect.");
        }

        // Calculate the y-coordinate of the intersection point
        return (T) Double.valueOf(
                ((Double) this.slope * (Double) intersectionX(otherLine)) +
                        (Double) this.yIntercept
        );
    }

    @Override
    protected Line<T> clone() {
        return new Line<>(slope, yIntercept);
    }
}