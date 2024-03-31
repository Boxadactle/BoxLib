package dev.boxadactle.boxlib.function;

/**
 * Represents a function that accepts nine arguments and returns no result.
 * This is the nine-arity specialization of the {@link java.util.function.Consumer} functional interface.
 *
 * @param <T> the type of the first argument
 * @param <S> the type of the second argument
 * @param <C> the type of the third argument
 * @param <G> the type of the fourth argument
 * @param <J> the type of the fifth argument
 * @param <K> the type of the sixth argument
 * @param <L> the type of the seventh argument
 * @param <Z> the type of the eighth argument
 * @param <X> the type of the ninth argument
 */
@FunctionalInterface
public interface Consumer9<T, S, C, G, J, K, L, Z, X> {

    /**
     * Performs this operation on the given arguments.
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
     */
    void accept(T val1, S val2, C val3, G val4, J val5, K val6, L val7, Z val8, X val9);

}
