package dev.boxadactle.boxlib.math.mathutils;

public class Lerps {

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static double lerpCircular(double a, double b, double t) {
        return (1 - t) * a + t * b;
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
