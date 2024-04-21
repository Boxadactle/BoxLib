package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field for inputting ARGB color values.
 */
public class BArgbField extends BOptionTextField<Integer> {

    /**
     * Constructs a new BArgbField with the specified initial value and function.
     *
     * @param value    the initial value of the field
     * @param function the function to be called when the value changes
     */
    public BArgbField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    /**
     * Converts the input string to an Integer value representing the ARGB color.
     *
     * @param input the input string to be converted
     * @return the Integer value representing the ARGB color, or null if the input is invalid
     */
    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.parseUnsignedInt(input.replaceAll("#", ""), 16);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException e) {
            this.setInvalid(true);
            return null;
        }
    }

    /**
     * Converts the Integer value representing the ARGB color to a string.
     *
     * @param input the Integer value representing the ARGB color
     * @return the string representation of the ARGB color
     */
    @Override
    public String from(Integer input) {
        return Integer.toHexString(input);
    }
}
