package dev.boxadactle.boxlib.math.geometry;

public class Dimension3D<T extends Number> {
    public T width;
    public T height;
    public T depth;

    public Dimension3D(T width, T height, T depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public T getWidth() {
        return width;
    }

    public T getHeight() {
        return height;
    }

    public T getDepth() {
        return depth;
    }
}
