package dev.boxadactle.boxlib.math;

public class Rect<T extends Number> {

    T x;
    T y;

    T width;
    T height;

    public Rect(T x, T y, T width, T height) {

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getWidth() {
        return width;
    }

    public T getHeight() {
        return height;
    }

    public int getMaxX() {
        return ((int)x + (int)width);
    }

    public int getMaxY() {
        return (int)y + (int)height;
    }

    public int getCenterY() {
        return (int)y + (int)height / 2;
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void setWidth(T width) {
        this.width = width;
    }

    public void setHeight(T height) {
        this.height = height;
    }

    public double getArea() {
        return (double)width * (double)height;
    }

    public double calculateDiagonalLength() {
        return Math.sqrt((Double)width * (Double)width + (Double)height * (Double)height);
    }

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
