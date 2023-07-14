package dev.boxadactle.boxlib.math;

public class Vec2<T extends Number> {

    T x;
    T y;

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
}
