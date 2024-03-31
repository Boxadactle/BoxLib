package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for inputting floating-point numbers.
 * Extends the BOptionTextField class.
 */
public class BFloatField extends BOptionTextField<Float> {
    /**
     * Constructs a BFloatField with the specified initial value and callback function.
     *
     * @param value    the initial value of the field
     * @param function the callback function to be called when the value changes
     */
    public BFloatField(Float value, Consumer<Float> function) {
        super(value, function);
    }

    /**
     * Converts the input string to a Float value.
     * Sets the invalid flag to false if the conversion is successful.
     * Sets the invalid flag to true if the conversion fails.
     *
     * @param input the input string to be converted
     * @return the converted Float value, or null if the conversion fails
     */
    @Override
    public Float to(String input) {
        try {
            Float a = Float.parseFloat(input);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Float value to a string representation.
     *
     * @param input the Float value to be converted
     * @return the string representation of the Float value
     */
    @Override
    public String from(Float input) {
        return Float.toString(input);
    }
}
