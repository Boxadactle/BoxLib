package dev.boxadactle.boxlib.function;

@FunctionalInterface
public interface Consumer4<T, S, C, G> {

    void accept(T val1, S val2, C val3, G val4);

}
