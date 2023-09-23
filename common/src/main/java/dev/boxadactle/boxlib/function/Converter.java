package dev.boxadactle.boxlib.function;

public interface Converter<T, S> {

    T to(S input);

    S from(T input);

}
