package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field for hexadecimal values.
 * Extends the BOptionTextField class.
 */
public class BHexField extends BOptionTextField<Integer> {

    /**
     * Constructs a BHexField object with the specified initial value and function.
     *
     * @param value    the initial value of the field
     * @param function the function to be called when the value of the field changes
     */
    public BHexField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    /**
     * Converts the input string to an Integer value.
     *
     * @param input the input string to be converted
     * @return the converted Integer value
     */
    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.valueOf(input.replaceAll("#", ""), 16);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException e) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Integer value to a hexadecimal string.
     *
     * @param input the Integer value to be converted
     * @return the hexadecimal string representation of the input value
     */
    @Override
    public String from(Integer input) {
        return Integer.toHexString(input);
    }
}
