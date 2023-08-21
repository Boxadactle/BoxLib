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
    
    public static Rect<Double> clampRect(
            double innerX, double innerY, double innerWidth, double innerHeight, 
            double outerX, double outerY, double outerWidth, double outerHeight
    ) {

        double clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        double clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(
                clampedX, clampedY, innerWidth, innerHeight
        );
    }

    public static Rect<Float> clampRect(
            float innerX, float innerY, float innerWidth, float innerHeight,
            float outerX, float outerY, float outerWidth, float outerHeight
    ) {

        float clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        float clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(
                clampedX, clampedY, innerWidth, innerHeight
        );
    }

    public static Rect<Integer> clampRect(
            int innerX, int innerY, int innerWidth, int innerHeight,
            int outerX, int outerY, int outerWidth, int outerHeight
    ) {

        int clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        int clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(
                clampedX, clampedY, innerWidth, innerHeight
        );
    }

    public static Rect<Long> clampRect(
            long innerX, long innerY, long innerWidth, long innerHeight,
            long outerX, long outerY, long outerWidth, long outerHeight
    ) {

        long clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        long clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(
                clampedX, clampedY, innerWidth, innerHeight
        );
    }

}
