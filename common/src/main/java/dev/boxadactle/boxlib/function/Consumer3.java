package dev.boxadactle.boxlib.function;

@FunctionalInterface
public interface Consumer3<T, S, C> {

    void accept(T val1, S val2, C val3);

}
