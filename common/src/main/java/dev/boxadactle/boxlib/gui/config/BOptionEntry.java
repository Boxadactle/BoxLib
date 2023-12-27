package dev.boxadactle.boxlib.gui.config;

public interface BOptionEntry<T> {

    T handleInput(T input);

    default boolean isInvalid() {
        return false;
    };

}
