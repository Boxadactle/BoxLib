package dev.boxadactle.boxlib.math.geometry;

@SuppressWarnings("unchecked")
public class Triangle<T extends Number> {
    private Vec2<T> vertex1;
    private Vec2<T> vertex2;
    private Vec2<T> vertex3;

    public Triangle(Vec2<T> vertex1, Vec2<T> vertex2, Vec2<T> vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    public Vec2<T> getVertex1() {
        return vertex1;
    }

    public Vec2<T> getVertex2() {
        return vertex2;
    }

    public Vec2<T> getVertex3() {
        return vertex3;
    }

    public T getPerimeter() {
        double side1 = (double) calculateDistance(vertex1, vertex2);
        double side2 = (double) calculateDistance(vertex2, vertex3);
        double side3 = (double) calculateDistance(vertex3, vertex1);
        return (T) Double.valueOf(side1 + side2 + side3);
    }

    public T getArea() {
        double side1 = (double) calculateDistance(vertex1, vertex2);
        double side2 = (double) calculateDistance(vertex2, vertex3);
        double side3 = (double) calculateDistance(vertex3, vertex1);
        double s = (side1 + side2 + side3) / 2;
        return (T) Double.valueOf(Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)));
    }

    public boolean containsPoint(Vec2<T> point) {
        double areaABC = (double) getArea();
        double areaPBC = (double) new Triangle<>(point, vertex2, vertex3).getArea();
        double areaPCA = (double) new Triangle<>(vertex1, point, vertex3).getArea();
        double areaPAB = (double) new Triangle<>(vertex1, vertex2, point).getArea();
        return Math.abs(areaABC - (areaPBC + areaPCA + areaPAB)) < 1e-9; // Adjust epsilon as needed
    }

    private T calculateDistance(Vec2<T> p1, Vec2<T> p2) {
        double dx = p2.getX().doubleValue() - p1.getX().doubleValue();
        double dy = p2.getY().doubleValue() - p1.getY().doubleValue();
        return (T) Double.valueOf(Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    protected Triangle<T> clone() {
        return new Triangle<>(vertex1, vertex2, vertex3);
    }
}