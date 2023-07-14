package dev.boxadactle.boxlib.math;

public class MathHelper {

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static double lerpCircular(double a, double b, double t) {
        return (1 - t) * a + t * b;
    }

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(x2 - x1, 2) + java.lang.Math.pow(y2 - y1, 2) + java.lang.Math.pow(z2 - z1, 2));
    }

    public static double pythagoreanTheorem(double a, double b) {
        return java.lang.Math.sqrt(java.lang.Math.pow(a, 2) + java.lang.Math.pow(b, 2));
    }

    public static double calculatePercentage(double part, double whole) {
        return (part / whole) * 100;
    }

    public static int randomInt(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }

    public static double mapValue(double value, double inMin, double inMax, double outMin, double outMax) {
        return (value - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }

    public static double[] quadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return new double[0]; // No real roots
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            double root1 = (-b + java.lang.Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - java.lang.Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        }
    }

    public static Object selectRandom(Object ...args) {
        return args[(int) java.lang.Math.round(java.lang.Math.random() * (args.length - 1))];
    }

    public static int aspectRatio(int int1, int int2, int int3) {
        int i1 = int3 / int1;
        return int2 * i1;
    }

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
            return value > max ? max : value;
        }
    }

    public static long clamp(long value, long min, long max) {
        if (value < min) {
            return min;
        } else {
            return value > max ? max : value;
        }
    }

    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        } else {
            return value > max ? max : value;
        }
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else {
            return value > max ? max : value;
        }
    }

    public static double clampedLerp(double start, double end, double delta) {
        if (delta < 0.0) {
            return start;
        } else {
            return delta > 1.0 ? end : lerp(delta, start, end);
        }
    }

    public static float clampedLerp(float start, float end, float delta) {
        if (delta < 0.0F) {
            return start;
        } else {
            return delta > 1.0F ? end : (float) lerp(delta, start, end);
        }
    }

}
