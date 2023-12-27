package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

public class BDoubleField extends BOptionTextField<Double> {
    public BDoubleField(Double value, Consumer<Double> function) {
        super(value, function);
    }

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

    @Override
    public String from(Double input) {
        return Double.toString(input);
    }
}
