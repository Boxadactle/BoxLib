package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for handling string values.
 */
public class BStringField extends BOptionTextField<String> {
    /**
     * Constructs a new BStringField with the specified initial value and function.
     *
     * @param value    the initial value of the text field
     * @param function the function to be called when the value of the text field changes
     */
    public BStringField(String value, Consumer<String> function) {
        super(value, function);
    }

    /**
     * Converts the input string to a string.
     *
     * @param input the input string
     * @return the converted string
     */
    @Override
    public String to(String input) {
        return input;
    }

    /**
     * Converts the input string from a string.
     *
     * @param input the input string
     * @return the converted string
     */
    @Override
    public String from(String input) {
        return input;
    }
}
