package dev.boxadactle.boxlib.math;

public class Dimension<T extends Number> {

    T width;
    T height;

    public Dimension(T width, T height) {
        this.width = width;
        this.height = height;
    }

    public T getWidth() {
        return width;
    }

    public T getHeight() {
        return height;
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
}
