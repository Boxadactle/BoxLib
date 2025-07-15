package dev.boxadactle.boxlib.function;

/**
 * Represents an operation that accepts two input arguments and returns no result.
 * This is the two-arity specialization of {@link java.util.function.Consumer}.
 *
 * @param <T> the type of the first input argument
 * @param <S> the type of the second input argument
 */
@FunctionalInterface
public interface Consumer2<T, S> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param val1 the first input argument
     * @param val2 the second input argument
     */
    void accept(T val1, S val2);

}
