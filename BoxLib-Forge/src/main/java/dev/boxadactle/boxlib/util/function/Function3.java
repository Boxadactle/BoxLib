package dev.boxadactle.boxlib.util.function;

@FunctionalInterface
public interface Function3<T, S, D, A> {

    A accept(T val1, S val2, D val3);

}
