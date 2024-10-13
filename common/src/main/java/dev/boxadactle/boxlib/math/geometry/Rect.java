package dev.boxadactle.boxlib.math.geometry;

/**
 * Represents a rectangle in a 2D coordinate system.
 *
 * @param <T> the type of the coordinates and dimensions of the rectangle
 */
@SuppressWarnings("unchecked")
public class Rect<T extends Number> {

    public T x;
    public T y;

    public T width;
    public T height;

    /**
     * Constructs a new rectangle with the specified coordinates and dimensions.
     *
     * @param x      the x-coordinate of the top-left corner of the rectangle
     * @param y      the y-coordinate of the top-left corner of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rect(T x, T y, T width, T height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the x-coordinate of the top-left corner of the rectangle.
     *
     * @return the x-coordinate of the top-left corner
     */
    public T getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the top-left corner of the rectangle.
     *
     * @return the y-coordinate of the top-left corner
     */
    public T getY() {
        return y;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public T getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public T getHeight() {
        return height;
    }

    /**
     * Returns the x-coordinate of the bottom-right corner of the rectangle.
     *
     * @return the x-coordinate of the bottom-right corner
     */
    public int getMaxX() {
        return ((int) x + (int) width);
    }

    /**
     * Returns the y-coordinate of the bottom-right corner of the rectangle.
     *
     * @return the y-coordinate of the bottom-right corner
     */
    public int getMaxY() {
        return (int) y + (int) height;
    }

    /**
     * Returns the y-coordinate of the center of the rectangle.
     *
     * @return the y-coordinate of the center
     */
    public int getCenterY() {
        return (int) y + (int) height / 2;
    }

    /**
     * Sets the x-coordinate of the top-left corner of the rectangle.
     *
     * @param x the new x-coordinate
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the top-left corner of the rectangle.
     *
     * @param y the new y-coordinate
     */
    public void setY(T y) {
        this.y = y;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width the new width
     */
    public void setWidth(T width) {
        this.width = width;
    }

    /**
     * Sets the height of the rectangle.
     *
     * @param height the new height
     */
    public void setHeight(T height) {
        this.height = height;
    }

    /**
     * Returns the area of the rectangle.
     *
     * @return the area of the rectangle
     */
    public double getArea() {
        return (double) width * (double) height;
    }

    /**
     * Calculates and returns the length of the diagonal of the rectangle.
     *
     * @return the length of the diagonal
     */
    public double calculateDiagonalLength() {
        return Math.sqrt((Double) width * (Double) width + (Double) height * (Double) height);
    }

    /**
     * Returns the perimeter of the rectangle.
     *
     * @return the perimeter of the rectangle
     */
    public T getPerimeter() {
        T perimeter = (T) Double.valueOf(
                (width.doubleValue() + height.doubleValue()) * 2.0
        );
        return perimeter;
    }

    /**
     * Checks if the specified point is inside the rectangle.
     *
     * @param point the point to check
     * @return true if the point is inside the rectangle, false otherwise
     */
    public boolean containsPoint(Vec2<T> point) {
        double pointX = point.getX().doubleValue();
        double pointY = point.getY().doubleValue();

        double rectMinX = x.doubleValue();
        double rectMaxX = x.doubleValue() + width.doubleValue();
        double rectMinY = y.doubleValue();
        double rectMaxY = y.doubleValue() + height.doubleValue();

        return pointX >= rectMinX && pointX <= rectMaxX &&
                pointY >= rectMinY && pointY <= rectMaxY;
    }

    /**
     * Creates and returns a copy of this rectangle.
     *
     * @return a copy of this rectangle
     */
    @Override
    public Rect<T> clone() {
        return new Rect<>(x, y, width, height);
    }

    /**
     * Returns a string representation of this rectangle.
     *
     * @return a string representation of this rectangle
     */
    @Override
    public String toString() {
        return "Rect{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
