package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

public class BFloatField extends BOptionTextField<Float> {
    public BFloatField(Float value, Consumer<Float> function) {
        super(value, function);
    }

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

    @Override
    public String from(Float input) {
        return Float.toString(input);
    }
}
