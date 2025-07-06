package dev.boxadactle.boxlib.function;

/**
 * Represents a function that accepts two arguments and produces a result.
 *
 * @param <T> the type of the first argument
 * @param <S> the type of the second argument
 * @param <A> the type of the result
 */
@FunctionalInterface
public interface Function2<T, S, A> {

    /**
     * Applies this function to the given arguments.
     *
     * @param val1 the first argument
     * @param val2 the second argument
     * @return the result of the function
     */
    A accept(T val1, S val2);

}
