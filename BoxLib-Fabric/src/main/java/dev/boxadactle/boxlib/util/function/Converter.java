package dev.boxadactle.boxlib.util.function;

public interface Converter<T, S> {

    T to(S input);

    S from(T input);

}
