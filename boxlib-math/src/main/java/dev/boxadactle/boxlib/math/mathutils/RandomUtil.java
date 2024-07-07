package dev.boxadactle.boxlib.math.mathutils;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

import java.util.List;
import java.util.Random;

/**
 * The RandomUtil class provides utility methods for generating random numbers and performing random operations.
 */
@SuppressWarnings("unchecked")
public class RandomUtil {
    private static final Random random = new Random();

    /**
     * Generates a random integer within the specified range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxExclusive the maximum exclusive value of the range
     * @return a random integer within the specified range
     */
    public static int generateInt(int minInclusive, int maxExclusive) {
        return random.nextInt(maxExclusive - minInclusive) + minInclusive;
    }

    /**
     * Generates a random double within the specified range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxExclusive the maximum exclusive value of the range
     * @return a random double within the specified range
     */
    public static double generateDouble(double minInclusive, double maxExclusive) {
        return minInclusive + random.nextDouble() * (maxExclusive - minInclusive);
    }

    /**
     * Generates a random boolean value.
     *
     * @return a random boolean value
     */
    public static boolean generateBoolean() {
        return random.nextBoolean();
    }

    /**
     * Selects a random element from the given array.
     *
     * @param list the array of elements
     * @param <T>  the type of elements in the array
     * @return a random element from the array
     */
    public static <T> T selectRandom(T... list) {
        return selectRandom(Lists.newArrayList(list));
    }

    /**
     * Selects a random element from the given list.
     *
     * @param list the list of elements
     * @param <T>  the type of elements in the list
     * @return a random element from the list
     * @throws IllegalArgumentException if the list is null or empty
     */
    public static <T> T selectRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty.");
        }

        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    /**
     * Shuffles the elements in the given list.
     *
     * @param list the list to be shuffled
     * @param <T>  the type of elements in the list
     */
    public static <T> void shuffleList(List<T> list) {
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(list, i, j);
        }
    }

    /**
     * Swaps the elements at the specified positions in the given list.
     *
     * @param list the list containing the elements
     * @param i    the index of the first element to be swapped
     * @param j    the index of the second element to be swapped
     * @param <T>  the type of elements in the list
     */
    public static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Generates a random integer within the specified inclusive range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxInclusive the maximum inclusive value of the range
     * @return a random integer within the specified range
     * @throws IllegalArgumentException if maxInclusive is less than minInclusive
     */
    public static int randomInRange(int minInclusive, int maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return random.nextInt(maxInclusive - minInclusive + 1) + minInclusive;
    }

    /**
     * Generates a random long integer within the specified inclusive range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxInclusive the maximum inclusive value of the range
     * @return a random long integer within the specified range
     * @throws IllegalArgumentException if maxInclusive is less than minInclusive
     */
    public static long generateInRange(long minInclusive, long maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return random.nextLong() % (maxInclusive - minInclusive + 1) + minInclusive;
    }

    /**
     * Generates a random double within the specified inclusive range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxInclusive the maximum inclusive value of the range
     * @return a random double within the specified range
     * @throws IllegalArgumentException if maxInclusive is less than minInclusive
     */
    public static double generateInRange(double minInclusive, double maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return minInclusive + random.nextDouble() * (maxInclusive - minInclusive);
    }

    /**
     * Generates a random float within the specified inclusive range.
     *
     * @param minInclusive the minimum inclusive value of the range
     * @param maxInclusive the maximum inclusive value of the range
     * @return a random float within the specified range
     * @throws IllegalArgumentException if maxInclusive is less than minInclusive
     */
    public static float generateInRange(float minInclusive, float maxInclusive) {
        if (maxInclusive < minInclusive) {
            throw new IllegalArgumentException("maxInclusive must be greater than or equal to minInclusive.");
        }
        return minInclusive + random.nextFloat() * (maxInclusive - minInclusive);
    }
}
