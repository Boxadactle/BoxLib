package dev.boxadactle.boxlib.math.mathutils;

/**
 * The Mappers class provides utility methods for mapping and wrapping values.
 */
public class Mappers {

    /**
     * Wraps an integer value within a specified range.
     *
     * @param i   The value to wrap.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static int wrap(int i, int max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    /**
     * Wraps a double value within a specified range.
     *
     * @param i   The value to wrap.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static double wrap(double i, double max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    /**
     * Wraps a float value within a specified range.
     *
     * @param i   The value to wrap.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static float wrap(float i, float max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    /**
     * Wraps an integer value within a specified range.
     *
     * @param i   The value to wrap.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static int wrap(int i, int min, int max) {
        int j = i - min;
        int k = max - min;
        int l = wrap(j, k);
        return l + min;
    }

    /**
     * Wraps a double value within a specified range.
     *
     * @param i   The value to wrap.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static double wrap(double i, double min, double max) {
        double j = i - min;
        double k = max - min;
        double l = wrap(j, k);
        return l + min;
    }

    /**
     * Wraps a float value within a specified range.
     *
     * @param i   The value to wrap.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return The wrapped value.
     */
    public static float wrap(float i, float min, float max) {
        float j = i - min;
        float k = max - min;
        float l = wrap(j, k);
        return l + min;
    }

    /**
     * Maps a double value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static double map(double value, double min, double max) {
        return ((max - min) * value) + min;
    }

    /**
     * Maps a float value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static float map(float value, float min, float max) {
        return ((max - min) * value) + min;
    }

    /**
     * Maps a double value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static int map(double value, int min, int max) {
        return (int) Math.round(((max - min) * value) + min);
    }

    /**
     * Maps a float value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static int map(float value, int min, int max) {
        return Math.round(((max - min) * value) + min);
    }

    /**
     * Maps a double value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static long map(double value, long min, long max) {
        return Math.round(((max - min) * value) + min);
    }

    /**
     * Maps a float value from one range to another.
     *
     * @param value The value to map.
     * @param min   The minimum value of the source range.
     * @param max   The maximum value of the source range.
     * @return The mapped value.
     */
    public static long map(float value, long min, long max) {
        return Math.round(((max - min) * value) + min);
    }

    /**
     * Normalizes a double value within a specified range.
     *
     * @param value The value to normalize.
     * @param min   The minimum value of the range.
     * @param max   The maximum value of the range.
     * @return The normalized value.
     */
    public static double normalizeMap(double value, double min, double max) {
        return value / (max - min);
    }

    /**
     * Normalizes a float value within a specified range.
     *
     * @param value The value to normalize.
     * @param min   The minimum value of the range.
     * @param max   The maximum value of the range.
     * @return The normalized value.
     */
    public static float normalizeMap(float value, float min, float max) {
        return value / (max - min);
    }

    /**
     * Normalizes an integer value within a specified range.
     *
     * @param value The value to normalize.
     * @param min   The minimum value of the range.
     * @param max   The maximum value of the range.
     * @return The normalized value.
     */
    public static double normalizeMap(int value, int min, int max) {
        return (double) value / (max - min);
    }

}
