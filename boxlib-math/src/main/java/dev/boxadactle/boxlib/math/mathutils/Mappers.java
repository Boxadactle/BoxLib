package dev.boxadactle.boxlib.math.mathutils;

public class Mappers {

    public static int wrap(int i, int max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    public static double wrap(double i, double max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    public static float wrap(float i, float max) {
        if (i < 0) return max + (i % max);
        return i % max;
    }

    public static int wrap(int i, int min, int max) {
        int j = i - min;
        int k = max - min;
        int l = wrap(j, k);
        return l + min;
    }

    public static double wrap(double i, double min, double max) {
        double j = i - min;
        double k = max - min;
        double l = wrap(j, k);
        return l + min;
    }

    public static float wrap(float i, float min, float max) {
        float j = i - min;
        float k = max - min;
        float l = wrap(j, k);
        return l + min;
    }



}
