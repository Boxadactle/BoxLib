package dev.boxadactle.boxlib.function;

@FunctionalInterface
public interface Function4<T, S, D, F, A> {

    A accept(T val1, S val2, D val3, F val4);

}
