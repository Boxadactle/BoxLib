package dev.boxadactle.boxlib.gui.widget.slider;

import dev.boxadactle.boxlib.gui.BOptionSlider;

import java.util.function.Consumer;

/**
 * A slider widget that allows selecting integer values within a specified range.
 */
public class BIntegerSlider extends BOptionSlider<Integer> {
    /**
     * Constructs a new BIntegerSlider with the specified parameters.
     *
     * @param key      the unique identifier for the slider
     * @param min      the minimum value of the slider
     * @param max      the maximum value of the slider
     * @param value    the initial value of the slider
     * @param function the function to be called when the slider value changes
     */
    public BIntegerSlider(String key, int min, int max, int value, Consumer<Integer> function) {
        super(key, min, max, value, function);
    }

    /**
     * Converts a double value to an integer value.
     *
     * @param input the double value to be converted
     * @return the converted integer value
     */
    @Override
    public Integer to(Double input) {
        return input.intValue();
    }

    /**
     * Converts an integer value to a double value.
     *
     * @param input the integer value to be converted
     * @return the converted double value
     */
    @Override
    public Double from(Integer input) {
        return input.doubleValue();
    }

    /**
     * Rounds the integer value to a string representation.
     *
     * @param input the integer value to be rounded
     * @return the rounded string representation of the integer value
     */
    @Override
    protected String roundNumber(Integer input) {
        return Integer.toString(input);
    }
}
