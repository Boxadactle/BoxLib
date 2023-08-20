package dev.boxadactle.boxlib.math.mathutils;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int generateInt(int minInclusive, int maxExclusive) {
        return random.nextInt(maxExclusive - minInclusive) + minInclusive;
    }

    public static double generateDouble(double minInclusive, double maxExclusive) {
        return minInclusive + random.nextDouble() * (maxExclusive - minInclusive);
    }

    public static boolean generateBoolean() {
        return random.nextBoolean();
    }

    public static <T> T selectRandom(T ...list) {
        return selectRandom(Lists.newArrayList(list));
    }

    public static <T> T selectRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static <T> void shuffleList(List<T> list) {
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(list, i, j);
        }
    }

    public static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static int randomInRange(int minInclusive, int maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return random.nextInt(maxInclusive - minInclusive + 1) + minInclusive;
    }

    public static long generateInRange(long minInclusive, long maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return random.nextLong() % (maxInclusive - minInclusive + 1) + minInclusive;
    }

    public static double generateInRange(double minInclusive, double maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return minInclusive + random.nextDouble() * (maxInclusive - minInclusive);
    }

    public static float generateInRange(float minInclusive, float maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return minInclusive + random.nextFloat() * (maxInclusive - minInclusive);
    }

}
