package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;

import java.util.function.Consumer;

/**
 * A slider widget specifically designed for long values.
 */
public class BLongSlider extends BOptionSlider<Long> {

    /**
     * Constructs a BLongSlider with the specified parameters.
     *
     * @param key      the key associated with the slider
     * @param min      the minimum value of the slider
     * @param max      the maximum value of the slider
     * @param value    the initial value of the slider
     * @param function the function to be called when the slider value changes
     */
    public BLongSlider(String key, long min, long max, long value, Consumer<Long> function) {
        super(key, min, max, value, function);
    }

    /**
     * Converts a double value to a long value.
     *
     * @param input the double value to be converted
     * @return the converted long value
     */
    @Override
    public Long to(Double input) {
        return input.longValue();
    }

    /**
     * Converts a long value to a double value.
     *
     * @param input the long value to be converted
     * @return the converted double value
     */
    @Override
    public Double from(Long input) {
        return input.doubleValue();
    }

    /**
     * Rounds a long number to a string representation.
     *
     * @param input the long number to be rounded
     * @return the rounded number as a string
     */
    @Override
    protected String roundNumber(Long input) {
        return Long.toString(input);
    }
}
