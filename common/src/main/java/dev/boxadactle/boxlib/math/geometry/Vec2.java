package dev.boxadactle.boxlib.math.geometry;

/**
 * Represents a 2-dimensional vector with generic coordinates.
 *
 * @param <T> the type of the coordinates (must extend Number)
 */
public class Vec2<T extends Number> {

    public T x;
    public T y;

    /**
     * Constructs a new Vec2 object with the specified coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Vec2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this vector.
     *
     * @return the x-coordinate
     */
    public T getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of this vector.
     *
     * @return the y-coordinate
     */
    public T getY() {
        return y;
    }

    /**
     * Sets the x-coordinate of this vector.
     *
     * @param x the new x-coordinate
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of this vector.
     *
     * @param y the new y-coordinate
     */
    public void setY(T y) {
        this.y = y;
    }
    /**
     * Returns a string representation of this vector.
     *
     * @return a string representation of this vector
     */
    @Override
    public String toString() {
        return "Vec2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Creates and returns a copy of this vector.
     *
     * @return a clone of this vector
     */
    @Override
    protected Vec2<T> clone() {
        return new Vec2<>(x, y);
    }
}
