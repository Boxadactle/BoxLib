package dev.boxadactle.boxlib.gui.config;

/**
 * The BOptionEntry interface represents an entry for a GUI option in the BoxLib library.
 * It provides a method to handle user input and a default method to check if the input is invalid.
 *
 * @param <T> the type of the input value
 */
public interface BOptionEntry<T> {

    /**
     * Handles the user input and returns the processed value.
     *
     * @param input the user input
     * @return the processed value
     */
    T handleInput(T input);

    /**
     * Checks if the input is invalid.
     *
     * @return true if the input is invalid, false otherwise
     */
    default boolean isInvalid() {
        return false;
    };

}
