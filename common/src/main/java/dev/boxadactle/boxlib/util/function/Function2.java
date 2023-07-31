package dev.boxadactle.boxlib.util.function;

@FunctionalInterface
public interface Function2<T, S, A> {

    A accept(T val1, S val2);

}
