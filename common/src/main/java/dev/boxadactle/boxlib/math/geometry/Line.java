package dev.boxadactle.boxlib.math.geometry;

@SuppressWarnings("unchecked")
public class Line<T extends Number> {
    private T slope;
    private T yIntercept;

    /**
     * Constructs a Line object with the given slope and y-intercept.
     *
     * @param slope      the slope of the line
     * @param yIntercept the y-intercept of the line
     */
    public Line(T slope, T yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    /**
     * Returns the slope of the line.
     *
     * @return the slope of the line
     */
    public T getSlope() {
        return slope;
    }

    /**
     * Returns the y-intercept of the line.
     *
     * @return the y-intercept of the line
     */
    public T getYIntercept() {
        return yIntercept;
    }

    /**
     * Checks if this line intersects with the given line.
     *
     * @param otherLine the other line to check intersection with
     * @return true if the lines intersect, false otherwise
     */
    public boolean intersects(Line<T> otherLine) {
        // Check if the two lines are not parallel
        return !this.slope.equals(otherLine.getSlope());
    }

    /**
     * Calculates the x-coordinate of the intersection point between this line and the given line.
     *
     * @param otherLine the other line to calculate intersection with
     * @return the x-coordinate of the intersection point
     * @throws IllegalArgumentException if the lines are parallel and do not intersect
     */
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

    /**
     * Calculates the y-coordinate of the intersection point between this line and the given line.
     *
     * @param otherLine the other line to calculate intersection with
     * @return the y-coordinate of the intersection point
     * @throws IllegalArgumentException if the lines are parallel and do not intersect
     */
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

    /**
     * Creates a copy of this Line object.
     *
     * @return a new Line object with the same slope and y-intercept
     */
    @Override
    protected Line<T> clone() {
        return new Line<>(slope, yIntercept);
    }
}