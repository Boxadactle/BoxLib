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

    public static Rect<Integer> clampRect(Rect<Integer> innerRect, Rect<Integer> outerRect) {
        int innerX = innerRect.getX();
        int innerY = innerRect.getY();
        int innerWidth = innerRect.getWidth();
        int innerHeight = innerRect.getHeight();

        int outerX = outerRect.getX();
        int outerY = outerRect.getY();
        int outerWidth = outerRect.getWidth();
        int outerHeight = outerRect.getHeight();

        int clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        int clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(clampedX, clampedY, innerWidth, innerHeight);
    }

    public static Rect<Long> clampRect(Rect<Long> innerRect, Rect<Long> outerRect) {
        long innerX = innerRect.getX();
        long innerY = innerRect.getY();
        long innerWidth = innerRect.getWidth();
        long innerHeight = innerRect.getHeight();

        long outerX = outerRect.getX();
        long outerY = outerRect.getY();
        long outerWidth = outerRect.getWidth();
        long outerHeight = outerRect.getHeight();

        long clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        long clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(clampedX, clampedY, innerWidth, innerHeight);
    }

    public static Rect<Float> clampRect(Rect<Float> innerRect, Rect<Float> outerRect) {
        float innerX = innerRect.getX();
        float innerY = innerRect.getY();
        float innerWidth = innerRect.getWidth();
        float innerHeight = innerRect.getHeight();

        float outerX = outerRect.getX();
        float outerY = outerRect.getY();
        float outerWidth = outerRect.getWidth();
        float outerHeight = outerRect.getHeight();

        float clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        float clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(clampedX, clampedY, innerWidth, innerHeight);
    }

    public static Rect<Double> clampRect(Rect<Double> innerRect, Rect<Double> outerRect) {
        double innerX = innerRect.getX();
        double innerY = innerRect.getY();
        double innerWidth = innerRect.getWidth();
        double innerHeight = innerRect.getHeight();

        double outerX = outerRect.getX();
        double outerY = outerRect.getY();
        double outerWidth = outerRect.getWidth();
        double outerHeight = outerRect.getHeight();

        double clampedX = clamp(innerX, outerX, outerX + outerWidth - innerWidth);
        double clampedY = clamp(innerY, outerY, outerY + outerHeight - innerHeight);

        return new Rect<>(clampedX, clampedY, innerWidth, innerHeight);
    }


}
