package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for entering short values.
 * Extends the BOptionTextField class.
 */
public class BShortField extends BOptionTextField<Short> {
    /**
     * Constructs a BShortField with the specified initial value and function.
     *
     * @param value    the initial value of the field
     * @param function the function to be called when the value of the field changes
     */
    public BShortField(Short value, Consumer<Short> function) {
        super(value, function);
    }

    /**
     * Converts the input string to a Short value.
     * Sets the invalid flag to false if the conversion is successful.
     * Sets the invalid flag to true if the conversion fails.
     *
     * @param input the input string to be converted
     * @return the converted Short value, or null if the conversion fails
     */
    @Override
    public Short to(String input) {
        try {
            Short a = Short.parseShort(input);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Short value to a string representation.
     *
     * @param input the Short value to be converted
     * @return the string representation of the Short value
     */
    @Override
    public String from(Short input) {
        return Short.toString(input);
    }
}
