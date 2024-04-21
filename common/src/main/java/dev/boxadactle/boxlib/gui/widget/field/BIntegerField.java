package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for integer values.
 * Extends the BOptionTextField class.
 */
public class BIntegerField extends BOptionTextField<Integer> {

    /**
     * Constructs a BIntegerField with the specified initial value and function.
     *
     * @param value    the initial value of the field
     * @param function the function to be called when the value of the field changes
     */
    public BIntegerField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    /**
     * Converts the input string to an Integer value.
     * Sets the invalid flag to false if the conversion is successful.
     * Sets the invalid flag to true if the conversion fails.
     *
     * @param input the input string to be converted
     * @return the converted Integer value, or null if the conversion fails
     */
    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.parseInt(input);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Integer value to a string representation.
     *
     * @param input the Integer value to be converted
     * @return the string representation of the Integer value
     */
    @Override
    public String from(Integer input) {
        return Integer.toString(input);
    }
}
