package dev.boxadactle.boxlib.function;

/**
 * Represents a function that accepts nine arguments and produces a result.
 *
 * @param <T> the type of the first argument
 * @param <S> the type of the second argument
 * @param <D> the type of the third argument
 * @param <F> the type of the fourth argument
 * @param <G> the type of the fifth argument
 * @param <H> the type of the sixth argument
 * @param <J> the type of the seventh argument
 * @param <K> the type of the eighth argument
 * @param <L> the type of the ninth argument
 * @param <A> the type of the result
 */
@FunctionalInterface
public interface Function9<T, S, D, F, G, H, J, K, L, A> {

    /**
     * Applies this function to the given arguments.
     *
     * @param val1 the first argument
     * @param val2 the second argument
     * @param val3 the third argument
     * @param val4 the fourth argument
     * @param val5 the fifth argument
     * @param val6 the sixth argument
     * @param val7 the seventh argument
     * @param val8 the eighth argument
     * @param val9 the ninth argument
     * @return the result of the function
     */
    A accept(T val1, S val2, D val3, F val4, G val5, H val6, J val7, K val8, L val9);

}
