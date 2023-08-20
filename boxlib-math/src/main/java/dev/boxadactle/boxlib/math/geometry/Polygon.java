package dev.boxadactle.boxlib.math.geometry;

import java.util.List;

@SuppressWarnings("unchecked")
public class Polygon<T extends Number> {
    private List<Vec2<T>> vertices;

    public Polygon(List<Vec2<T>> vertices) {
        this.vertices = vertices;
    }

    public List<Vec2<T>> getVertices() {
        return vertices;
    }

    public T getPerimeter() {
        double perimeter = 0;
        int numVertices = vertices.size();
        for (int i = 0; i < numVertices; i++) {
            Vec2<T> p1 = vertices.get(i);
            Vec2<T> p2 = vertices.get((i + 1) % numVertices);
            perimeter += (double) calculateDistance(p1, p2);
        }
        return (T) Double.valueOf(perimeter);
    }

    public T getArea() {
        double area = 0;
        int numVertices = vertices.size();
        for (int i = 0; i < numVertices; i++) {
            Vec2<T> p1 = vertices.get(i);
            Vec2<T> p2 = vertices.get((i + 1) % numVertices);
            area += (p1.getX().doubleValue() * p2.getY().doubleValue() -
                    p2.getX().doubleValue() * p1.getY().doubleValue());
        }
        return (T) Double.valueOf(Math.abs(area) / 2);
    }

    public boolean containsPoint(Vec2<T> point) {
        int wn = 0; // Winding number
        int numVertices = vertices.size();
        for (int i = 0; i < numVertices; i++) {
            Vec2<T> p1 = vertices.get(i);
            Vec2<T> p2 = vertices.get((i + 1) % numVertices);

            if (p1.getY().doubleValue() <= point.getY().doubleValue()) {
                if (p2.getY().doubleValue() > point.getY().doubleValue() &&
                        (double) isLeft(p1, p2, point) > 0) {
                    wn++;
                }
            } else {
                if (p2.getY().doubleValue() <= point.getY().doubleValue() &&
                        (double) isLeft(p1, p2, point) < 0) {
                    wn--;
                }
            }
        }
        return wn != 0;
    }

    private T isLeft(Vec2<T> p1, Vec2<T> p2, Vec2<T> point) {
        return (T) Double.valueOf((p2.getX().doubleValue() - p1.getX().doubleValue()) *
                (point.getY().doubleValue() - p1.getY().doubleValue()) -
                (point.getX().doubleValue() - p1.getX().doubleValue()) *
                        (p2.getY().doubleValue() - p1.getY().doubleValue()));
    }

    private T calculateDistance(Vec2<T> p1, Vec2<T> p2) {
        double dx = p2.getX().doubleValue() - p1.getX().doubleValue();
        double dy = p2.getY().doubleValue() - p1.getY().doubleValue();
        return (T) Double.valueOf(Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    protected Polygon<T> clone() {
        return new Polygon<>(vertices);
    }
}