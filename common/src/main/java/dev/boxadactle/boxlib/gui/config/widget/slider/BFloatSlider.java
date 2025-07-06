package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;
import dev.boxadactle.boxlib.math.mathutils.NumberFormatter;

import java.util.function.Consumer;

/**
 * A slider widget for floating-point values.
 */
public class BFloatSlider extends BOptionSlider<Float> {
    protected NumberFormatter<Float> formatter;

    /**
     * Constructs a BFloatSlider object.
     *
     * @param key            the key associated with the slider
     * @param min            the minimum value of the slider
     * @param max            the maximum value of the slider
     * @param value          the initial value of the slider
     * @param decimalPlaces  the number of decimal places to display
     * @param function       the function to be called when the slider value changes
     */
    public BFloatSlider(String key, float min, float max, float value, int decimalPlaces, Consumer<Float> function) {
        super(key, min, max, value, function);

        formatter = new NumberFormatter<>(decimalPlaces);
    }

    /**
     * Converts a Double value to a Float value.
     *
     * @param input  the Double value to convert
     * @return       the converted Float value
     */
    @Override
    public Float to(Double input) {
        return input.floatValue();
    }

    /**
     * Converts a Float value to a Double value.
     *
     * @param input  the Float value to convert
     * @return       the converted Double value
     */
    @Override
    public Double from(Float input) {
        return input.doubleValue();
    }

    /**
     * Rounds a Float number and returns it as a formatted String.
     *
     * @param input  the Float number to round
     * @return       the rounded number as a formatted String
     */
    @Override
    protected String roundNumber(Float input) {
        return formatter.formatDecimal(input);
    }
}
