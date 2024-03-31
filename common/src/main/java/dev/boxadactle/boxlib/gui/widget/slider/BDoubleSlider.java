package dev.boxadactle.boxlib.gui.widget.slider;

import dev.boxadactle.boxlib.gui.BOptionSlider;
import dev.boxadactle.boxlib.math.mathutils.NumberFormatter;

import java.util.function.Consumer;

/**
 * A slider widget for selecting double values.
 */
public class BDoubleSlider extends BOptionSlider<Double> {
    protected NumberFormatter<Double> formatter;

    /**
     * Constructs a BDoubleSlider object.
     *
     * @param key            the key associated with the slider
     * @param min            the minimum value of the slider
     * @param max            the maximum value of the slider
     * @param value          the initial value of the slider
     * @param decimalPlaces  the number of decimal places to display
     * @param function       the function to be called when the slider value changes
     */
    public BDoubleSlider(String key, double min, double max, double value, int decimalPlaces, Consumer<Double> function) {
        super(key, min, max, value, function);

        formatter = new NumberFormatter<>(decimalPlaces);
    }

    /**
     * Converts the input value to a Double.
     *
     * @param input  the input value
     * @return       the converted value
     */
    @Override
    public Double to(Double input) {
        return input;
    }

    /**
     * Converts the input value from a Double.
     *
     * @param input  the input value
     * @return       the converted value
     */
    @Override
    public Double from(Double input) {
        return input;
    }

    /**
     * Rounds the input number and returns it as a formatted string.
     *
     * @param input  the input number
     * @return       the rounded and formatted number as a string
     */
    @Override
    protected String roundNumber(Double input) {
        return formatter.formatDecimal(input);
    }
}
