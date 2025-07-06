package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

/**
 * A custom text field widget for entering double values.
 */
public class BDoubleField extends BOptionTextField<Double> {
    /**
     * Constructs a new BDoubleField with the specified initial value and callback function.
     *
     * @param value    the initial value of the field
     * @param function the callback function to be called when the value changes
     */
    public BDoubleField(Double value, Consumer<Double> function) {
        super(value, function);
    }

    /**
     * Converts the input string to a Double value.
     *
     * @param input the input string to be converted
     * @return the converted Double value, or null if the input is invalid
     */
    @Override
    public Double to(String input) {
        try {
            Double a = Double.parseDouble(input);

            this.setInvalid(false);

            return a;
        } catch (NumberFormatException e) {
            this.setInvalid(true);

            return null;
        }
    }

    /**
     * Converts the Double value to a string representation.
     *
     * @param input the Double value to be converted
     * @return the string representation of the input value
     */
    @Override
    public String from(Double input) {
        return Double.toString(input);
    }
}
