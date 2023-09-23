package dev.boxadactle.boxlib.math.mathutils;

public class BMath {

    // first 150 digits of pi so it's a little more accurate than the java Math class
    public static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128;

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    public static double pythagoreanTheorem(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double calculatePercentage(double part, double whole) {
        return (part / whole) * 100;
    }

    public static int aspectRatio(int int1, int int2, int int3) {
        int i1 = int3 / int1;
        return int2 * i1;
    }
}
