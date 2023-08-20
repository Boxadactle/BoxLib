package dev.boxadactle.boxlib.math.geometry;

@SuppressWarnings("unchecked")
public class Rect<T extends Number> {

    private T x;
    private T y;

    private T width;
    private T height;

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

    public T getPerimeter() {
        T perimeter = (T) Double.valueOf(
                (width.doubleValue() + height.doubleValue()) * 2.0
        );
        return perimeter;
    }

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

    @Override
    public Rect<T> clone() {
        return new Rect<>(x, y, width, height);
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
