package dev.boxadactle.boxlib.gui;

public interface BConfigEntry<T> {

    T handleInput(T input);

    default boolean isInvalid() {
        return false;
    };

}
