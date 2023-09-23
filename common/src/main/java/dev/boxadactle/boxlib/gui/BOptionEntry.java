package dev.boxadactle.boxlib.gui;

public interface BOptionEntry<T> {

    T handleInput(T input);

    default boolean isInvalid() {
        return false;
    };

}
