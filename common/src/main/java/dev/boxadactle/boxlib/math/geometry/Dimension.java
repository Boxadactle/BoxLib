package dev.boxadactle.boxlib.math.geometry;

/**
 * Represents the dimensions of an object.
 * The dimensions are defined by a width and a height.
 *
 * @param <T> the type of the dimensions (must extend Number)
 */
public class Dimension<T extends Number> {

    public T width;
    public T height;

    /**
     * Constructs a new Dimension object with the specified width and height.
     *
     * @param width  the width of the object
     * @param height the height of the object
     */
    public Dimension(T width, T height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the object.
     *
     * @return the width of the object
     */
    public T getWidth() {
        return width;
    }

    /**
     * Returns the height of the object.
     *
     * @return the height of the object
     */
    public T getHeight() {
        return height;
    }

    /**
     * Sets the width of the object.
     *
     * @param width the new width of the object
     */
    public void setWidth(T width) {
        this.width = width;
    }

    /**
     * Sets the height of the object.
     *
     * @param height the new height of the object
     */
    public void setHeight(T height) {
        this.height = height;
    }

    /**
     * Calculates and returns the area of the object.
     *
     * @return the area of the object
     */
    public double getArea() {
        return (double) width * (double) height;
    }

    /**
     * Creates and returns a copy of this Dimension object.
     *
     * @return a copy of this Dimension object
     */
    @Override
    public Dimension<T> clone() {
        return new Dimension<>(width, height);
    }
}
