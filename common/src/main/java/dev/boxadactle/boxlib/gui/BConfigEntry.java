package dev.boxadactle.boxlib.gui;

public interface BConfigEntry<T> {

    T handleInput(T input);

    void setHalfWidget(boolean halfButton);
    boolean isHalfWidget();
    default boolean isInvalid() {
        return false;
    };

    default void onUnselect() {
    }

    default void onSelect() {
    }

    default void tick() {
    }

}
