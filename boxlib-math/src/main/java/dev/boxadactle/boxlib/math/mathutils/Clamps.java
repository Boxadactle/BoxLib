package dev.boxadactle.boxlib.math.mathutils;

import dev.boxadactle.boxlib.math.geometry.Rect;

/**
 * The {@code Clamps} class provides utility methods for clamping values within a specified range.
 */
public class Clamps {

    /**
     * Clamps a byte value within the specified range.
     *
     * @param value the value to clamp
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @return the clamped value
     */
    public static byte clamp(byte value, byte min, byte max) {
        if (value < min) {
            return min;
        } else {
            return value > max ? max : value;
        }
    }

    /**
     * Clamps an int value within the specified range.
     *
     * @param value the value to clamp
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @return the clamped value
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * Clamps a long value within the specified range.
     *
     * @param value the value to clamp
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @return the clamped value
     */
    public static long clamp(long value, long min, long max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * Clamps a float value within the specified range.
     *
     * @param value the value to clamp
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @return the clamped value
     */
    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * Clamps a double value within the specified range.
     *
     * @param value the value to clamp
     * @param min   the minimum value of the range
     * @param max   the maximum value of the range
     * @return the clamped value
     */
    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }

    /**
     * Clamps the coordinates and dimensions of a rectangle within the specified outer rectangle.
     *
     * @param innerX       the x-coordinate of the inner rectangle
     * @param innerY       the y-coordinate of the inner rectangle
     * @param innerWidth   the width of the inner rectangle
     * @param innerHeight  the height of the inner rectangle
     * @param outerX       the x-coordinate of the outer rectangle
     * @param outerY       the y-coordinate of the outer rectangle
     * @param outerWidth   the width of the outer rectangle
     * @param outerHeight  the height of the outer rectangle
     * @return a new rectangle with clamped coordinates and dimensions
     */
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

    /**
     * Clamps the coordinates and dimensions of a rectangle within the specified outer rectangle.
     *
     * @param innerX       the x-coordinate of the inner rectangle
     * @param innerY       the y-coordinate of the inner rectangle
     * @param innerWidth   the width of the inner rectangle
     * @param innerHeight  the height of the inner rectangle
     * @param outerX       the x-coordinate of the outer rectangle
     * @param outerY       the y-coordinate of the outer rectangle
     * @param outerWidth   the width of the outer rectangle
     * @param outerHeight  the height of the outer rectangle
     * @return a new rectangle with clamped coordinates and dimensions
     */
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

    /**
     * Clamps the coordinates and dimensions of a rectangle within the specified outer rectangle.
     *
     * @param innerX       the x-coordinate of the inner rectangle
     * @param innerY       the y-coordinate of the inner rectangle
     * @param innerWidth   the width of the inner rectangle
     * @param innerHeight  the height of the inner rectangle
     * @param outerX       the x-coordinate of the outer rectangle
     * @param outerY       the y-coordinate of the outer rectangle
     * @param outerWidth   the width of the outer rectangle
     * @param outerHeight  the height of the outer rectangle
     * @return a new rectangle with clamped coordinates and dimensions
     */
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

    /**
     * Clamps the coordinates and dimensions of a rectangle within the specified outer rectangle.
     *
     * @param innerX       the x-coordinate of the inner rectangle
     * @param innerY       the y-coordinate of the inner rectangle
     * @param innerWidth   the width of the inner rectangle
     * @param innerHeight  the height of the inner rectangle
     * @param outerX       the x-coordinate of the outer rectangle
     * @param outerY       the y-coordinate of the outer rectangle
     * @param outerWidth   the width of the outer rectangle
     * @param outerHeight  the height of the outer rectangle
     * @return a new rectangle with clamped coordinates and dimensions
     */
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
