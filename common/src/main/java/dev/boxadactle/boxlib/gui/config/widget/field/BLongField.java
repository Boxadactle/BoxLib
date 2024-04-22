package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for entering long values.
 * Extends the BOptionTextField class.
 */
public class BLongField extends BOptionTextField<Long> {
    /**
     * Constructs a BLongField with the specified initial value and function.
     *
     * @param value    the initial value of the field
     * @param function the function to be called when the value of the field changes
     */
    public BLongField(Long value, Consumer<Long> function) {
        super(value, function);
    }

    /**
     * Converts the input string to a Long value.
     * Sets the invalid flag to false if the conversion is successful.
     * Sets the invalid flag to true if the conversion fails.
     *
     * @param input the input string to be converted
     * @return the Long value if the conversion is successful, null otherwise
     */
    @Override
    public Long to(String input) {
        try {
            Long a = Long.parseLong(input);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Long value to a string representation.
     *
     * @param input the Long value to be converted
     * @return the string representation of the Long value
     */
    @Override
    public String from(Long input) {
        return Long.toString(input);
    }
}
