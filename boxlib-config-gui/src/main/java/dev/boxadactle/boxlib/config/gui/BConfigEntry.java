package dev.boxadactle.boxlib.config.gui;

public interface BConfigEntry<T> {

    T handleInput(T input);

    default boolean isInvalid() {
        return false;
    };

}
