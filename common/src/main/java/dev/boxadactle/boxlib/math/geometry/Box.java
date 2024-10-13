package dev.boxadactle.boxlib.math.geometry;

public class Box<T extends Number> {
    public T x;
    public T y;
    public T z;

    public T width;
    public T height;
    public T depth;
    
    public Box(T x, T y, T z, T width, T height, T depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box<T> setX(T x) {
        this.x = x;
        return this;
    }
    
    public Box<T> setY(T y) {
        this.y = y;
        return this;
    }
    
    public Box<T> setZ(T z) {
        this.z = z;
        return this;
    }
    
    public Box<T> setWidth(T width) {
        this.width = width;
        return this;
    }
    
    public Box<T> setHeight(T height) {
        this.height = height;
        return this;
    }
    
    public Box<T> setDepth(T depth) {
        this.depth = depth;
        return this;
    }
    
    public T getX() {
        return x;
    }
    
    public T getY() {
        return y;
    }
    
    public T getZ() {
        return z;
    }

    public double getWidth() {
        return maxX().doubleValue() - minX().doubleValue();
    }

    public double getHeight() {
        return maxY().doubleValue() - minY().doubleValue();
    }

    public double getDepth() {
        return maxZ().doubleValue() - minZ().doubleValue();
    }

    public T minX() {
        return x;
    }
    
    public T minY() {
        return y;
    }
    
    public T minZ() {
        return z;
    }
    
    @SuppressWarnings("unchecked")
    public T maxX() {
        return (T) (Number) (x.doubleValue() + width.doubleValue());
    }
    
    @SuppressWarnings("unchecked")
    public T maxY() {
        return (T) (Number) (y.doubleValue() + height.doubleValue());
    }
    
    @SuppressWarnings("unchecked")
    public T maxZ() {
        return (T) (Number) (z.doubleValue() + depth.doubleValue());
    }
    
    public boolean contains(Vec3<T> point) {
        return point.x.doubleValue() >= minX().doubleValue() && point.x.doubleValue() <= maxX().doubleValue() &&
                point.y.doubleValue() >= minY().doubleValue() && point.y.doubleValue() <= maxY().doubleValue() &&
                point.z.doubleValue() >= minZ().doubleValue() && point.z.doubleValue() <= maxZ().doubleValue();
    }

    public boolean contains(Box<T> box) {
        return box.minX().doubleValue() >= minX().doubleValue() && box.maxX().doubleValue() <= maxX().doubleValue() &&
                box.minY().doubleValue() >= minY().doubleValue() && box.maxY().doubleValue() <= maxY().doubleValue() &&
                box.minZ().doubleValue() >= minZ().doubleValue() && box.maxZ().doubleValue() <= maxZ().doubleValue();
    }

    public boolean intersects(Box<T> box) {
        return maxX().doubleValue() > box.minX().doubleValue() && minX().doubleValue() < box.maxX().doubleValue() &&
                maxY().doubleValue() > box.minY().doubleValue() && minY().doubleValue() < box.maxY().doubleValue() &&
                maxZ().doubleValue() > box.minZ().doubleValue() && minZ().doubleValue() < box.maxZ().doubleValue();
    }

    public Box<T> clone() {
        return new Box<>(minX(), minY(), minZ(), maxX(), maxY(), maxZ());
    }

    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }

}
