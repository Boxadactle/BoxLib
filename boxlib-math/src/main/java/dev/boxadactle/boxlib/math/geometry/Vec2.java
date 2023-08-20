package dev.boxadactle.boxlib.math.geometry;

public class Vec2<T extends Number> {

    private T x;
    private T y;

    public Vec2(T x, T y) {

        this.x = x;
        this.y = y;

    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vec2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    protected Vec2<T> clone() {
        return new Vec2<>(x, y);
    }
}
