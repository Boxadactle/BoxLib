package dev.boxadactle.boxlib.function;

/**
 * Represents an operation that accepts four input arguments and returns no result.
 * This is the four-arity specialization of the {@link java.util.function.Consumer} functional interface.
 *
 * @param <T> the type of the first input argument
 * @param <S> the type of the second input argument
 * @param <U> the type of the third input argument
 * @param <V> the type of the fourth input argument
 */
public interface Consumer4<T, S, U, V> {
    /**
     * Performs this operation on the given arguments.
     *
     * @param arg1 the first input argument
     * @param arg2 the second input argument
     * @param arg3 the third input argument
     * @param arg4 the fourth input argument
     */
    void accept(T arg1, S arg2, U arg3, V arg4);
}
