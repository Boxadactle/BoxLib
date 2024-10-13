package dev.boxadactle.boxlib.function;

/**
 * Represents a function that accepts five arguments and produces a result.
 *
 * @param <T> the type of the first argument
 * @param <S> the type of the second argument
 * @param <D> the type of the third argument
 * @param <F> the type of the fourth argument
 * @param <G> the type of the fifth argument
 * @param <A> the type of the result
 */
@FunctionalInterface
public interface Function5<T, S, D, F, G, A> {

    /**
     * Applies this function to the given arguments.
     *
     * @param val1 the first argument
     * @param val2 the second argument
     * @param val3 the third argument
     * @param val4 the fourth argument
     * @param val5 the fifth argument
     * @return the result of the function
     */
    A accept(T val1, S val2, D val3, F val4, G val5);

}
