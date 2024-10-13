package dev.boxadactle.boxlib.math.geometry;

/**
 * Represents a 3-dimensional vector with components of type T.
 *
 * @param <T> the type of the vector components
 */
public class Vec3<T extends Number> {

    public T x;
    public T y;
    public T z;

    /**
     * Constructs a new Vec3 object with the specified x, y, and z components.
     *
     * @param x the x component of the vector
     * @param y the y component of the vector
     * @param z the z component of the vector
     */
    public Vec3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x component of the vector.
     *
     * @return the x component of the vector
     */
    public T getX() {
        return x;
    }

    /**
     * Returns the y component of the vector.
     *
     * @return the y component of the vector
     */
    public T getY() {
        return y;
    }

    /**
     * Returns the z component of the vector.
     *
     * @return the z component of the vector
     */
    public T getZ() {
        return z;
    }

    /**
     * Sets the x component of the vector.
     *
     * @param x the new x component of the vector
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Sets the y component of the vector.
     *
     * @param y the new y component of the vector
     */
    public void setY(T y) {
        this.y = y;
    }

    /**
     * Sets the z component of the vector.
     *
     * @param z the new z component of the vector
     */
    public void setZ(T z) {
        this.z = z;
    }

    /**
     * Returns a string representation of the vector.
     *
     * @return a string representation of the vector
     */
    @Override
    public String toString() {
        return "Vec3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    /**
     * Creates and returns a copy of this Vec3 object.
     *
     * @return a clone of this instance
     */
    @Override
    protected Vec3<T> clone() {
        return new Vec3<>(x, y, z);
    }
}
