package dev.boxadactle.boxlib.math.mathutils;

/**
 * The Lerps class provides various methods for linear interpolation.
 */
public class Lerps {

    /**
     * Performs linear interpolation between two values.
     *
     * @param a The starting value.
     * @param b The ending value.
     * @param t The interpolation parameter, ranging from 0 to 1.
     * @return The interpolated value between a and b.
     */
    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    /**
     * Performs circular interpolation between two values.
     *
     * @param a The starting value.
     * @param b The ending value.
     * @param t The interpolation parameter, ranging from 0 to 1.
     * @return The interpolated value between a and b.
     */
    public static double lerpCircular(double a, double b, double t) {
        return (1 - t) * a + t * b;
    }

    /**
     * Performs clamped linear interpolation between two values.
     * The delta value is clamped between 0 and 1.
     *
     * @param start The starting value.
     * @param end The ending value.
     * @param delta The interpolation parameter, ranging from 0 to 1.
     * @return The interpolated value between start and end.
     */
    public static double clampedLerp(double start, double end, double delta) {
        if (delta < 0.0) {
            return start;
        } else {
            return delta > 1.0 ? end : lerp(delta, start, end);
        }
    }

    /**
     * Performs clamped linear interpolation between two values.
     * The delta value is clamped between 0 and 1.
     *
     * @param start The starting value.
     * @param end The ending value.
     * @param delta The interpolation parameter, ranging from 0 to 1.
     * @return The interpolated value between start and end.
     */
    public static float clampedLerp(float start, float end, float delta) {
        if (delta < 0.0F) {
            return start;
        } else {
            return delta > 1.0F ? end : (float) lerp(delta, start, end);
        }
    }

}
