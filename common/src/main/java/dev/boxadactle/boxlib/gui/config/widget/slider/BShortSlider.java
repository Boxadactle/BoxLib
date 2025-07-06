package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;

import java.util.function.Consumer;

/**
 * A slider widget specifically designed for short values.
 */
public class BShortSlider extends BOptionSlider<Short> {
    /**
     * Constructs a BShortSlider with the specified parameters.
     *
     * @param key      the key associated with the slider
     * @param min      the minimum value of the slider
     * @param max      the maximum value of the slider
     * @param value    the initial value of the slider
     * @param function the function to be called when the value of the slider changes
     */
    public BShortSlider(String key, short min, short max, short value, Consumer<Short> function) {
        super(key, min, max, value, function);
    }

    /**
     * Converts a double value to a short value.
     *
     * @param input the double value to be converted
     * @return the converted short value
     */
    @Override
    public Short to(Double input) {
        return input.shortValue();
    }

    /**
     * Converts a short value to a double value.
     *
     * @param input the short value to be converted
     * @return the converted double value
     */
    @Override
    public Double from(Short input) {
        return input.doubleValue();
    }

    /**
     * Rounds a short number to a string representation.
     *
     * @param input the short number to be rounded
     * @return the rounded number as a string
     */
    @Override
    protected String roundNumber(Short input) {
        return Short.toString(input);
    }
}
