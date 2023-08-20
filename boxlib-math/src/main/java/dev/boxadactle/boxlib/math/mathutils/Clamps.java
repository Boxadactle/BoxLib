package dev.boxadactle.boxlib.math.mathutils;

import dev.boxadactle.boxlib.math.geometry.Rect;

public class Clamps {

    public static byte clamp(byte value, byte min, byte max) {
        if (value < min) {
            return min;
        } else {
            return value > max ? max : value;
        }
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    public static long clamp(long value, long min, long max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> Rect<T> clampRect(Rect<T> innerRect, Rect<T> outerRect) {
        double innerX = (double) innerRect.getX();
        double innerY = (double) innerRect.getY();
        double innerWidth = (double) innerRect.getWidth();
        double innerHeight = (double) innerRect.getHeight();

        double outerX = (double) outerRect.getX();
        double outerY = (double) outerRect.getY();
        double outerWidth = (double) outerRect.getWidth();
        double outerHeight = (double) outerRect.getHeight();

        double clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        double clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(
                (T) Double.valueOf(clampedX),
                (T) Double.valueOf(clampedY),
                (T) Double.valueOf(innerWidth),
                (T) Double.valueOf(innerHeight)
        );
    }

}
