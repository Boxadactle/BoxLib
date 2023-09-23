package dev.boxadactle.boxlib.function;

@FunctionalInterface
public interface Function5<T, S, D, F, G, A> {

    A accept(T val1, S val2, D val3, F val4, G val5);

}
