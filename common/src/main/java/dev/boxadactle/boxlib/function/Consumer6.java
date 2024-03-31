package dev.boxadactle.boxlib.function;

/**
 * Represents an operation that accepts six input arguments and returns no result.
 * This is the six-arity specialization of the {@link java.util.function.Consumer} functional interface.
 *
 * @param <T> the type of the first input argument
 * @param <S> the type of the second input argument
 * @param <C> the type of the third input argument
 * @param <G> the type of the fourth input argument
 * @param <J> the type of the fifth input argument
 * @param <K> the type of the sixth input argument
 */
@FunctionalInterface
public interface Consumer6<T, S, C, G, J, K> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param val1 the first input argument
     * @param val2 the second input argument
     * @param val3 the third input argument
     * @param val4 the fourth input argument
     * @param val5 the fifth input argument
     * @param val6 the sixth input argument
     */
    void accept(T val1, S val2, C val3, G val4, J val5, K val6);

}
