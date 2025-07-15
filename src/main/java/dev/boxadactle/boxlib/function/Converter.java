package dev.boxadactle.boxlib.function;

/**
 * The Converter interface represents a generic converter that can convert between two types.
 *
 * @param <T> the type to convert to
 * @param <S> the type to convert from
 */
public interface Converter<T, S> {

    /**
     * Converts the input of type S to type T.
     *
     * @param input the input to convert
     * @return the converted value of type T
     */
    T to(S input);

    /**
     * Converts the input of type T to type S.
     *
     * @param input the input to convert
     * @return the converted value of type S
     */
    S from(T input);

}
