package dev.boxadactle.boxlib.math.mathutils;

/**
 * The BMath class provides various mathematical utility functions.
 */
public class BMath {

    /**
     * The value of pi, accurate to 150 decimal places.
     */
    public static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128;

    /**
     * Calculates the distance between two points in 3D space.
     *
     * @param x1 The x-coordinate of the first point.
     * @param y1 The y-coordinate of the first point.
     * @param z1 The z-coordinate of the first point.
     * @param x2 The x-coordinate of the second point.
     * @param y2 The y-coordinate of the second point.
     * @param z2 The z-coordinate of the second point.
     * @return The distance between the two points.
     */
    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    /**
     * Calculates the length of the hypotenuse of a right triangle using the Pythagorean theorem.
     *
     * @param a The length of one side of the triangle.
     * @param b The length of the other side of the triangle.
     * @return The length of the hypotenuse.
     */
    public static double pythagoreanTheorem(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Calculates the percentage of a part compared to a whole.
     *
     * @param part The value of the part.
     * @param whole The value of the whole.
     * @return The percentage.
     */
    public static double calculatePercentage(double part, double whole) {
        return (part / whole) * 100;
    }

    /**
     * Calculates the aspect ratio given two dimensions and a target dimension.
     *
     * @param int1 The first dimension.
     * @param int2 The second dimension.
     * @param int3 The target dimension.
     * @return The calculated aspect ratio.
     */
    public static int aspectRatio(int int1, int int2, int int3) {
        int i1 = int3 / int1;
        return int2 * i1;
    }
}
