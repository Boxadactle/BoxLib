package dev.boxadactle.boxlib.function;

/**
 * Represents an operation that accepts three input arguments and returns no result.
 * This is the three-arity specialization of the {@link java.util.function.Consumer} functional interface.
 *
 * @param <T> the type of the first input argument
 * @param <S> the type of the second input argument
 * @param <C> the type of the third input argument
 */
@FunctionalInterface
public interface Consumer3<T, S, C> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param val1 the first input argument
     * @param val2 the second input argument
     * @param val3 the third input argument
     */
    void accept(T val1, S val2, C val3);

}
