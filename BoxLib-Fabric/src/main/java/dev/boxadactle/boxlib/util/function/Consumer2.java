package dev.boxadactle.boxlib.util.function;

@FunctionalInterface
public interface Consumer2<T, S> {

    void accept(T val1, S val2);

}
