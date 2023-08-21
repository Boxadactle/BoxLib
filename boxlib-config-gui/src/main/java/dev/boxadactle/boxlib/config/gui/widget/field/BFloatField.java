package dev.boxadactle.boxlib.config.gui.widget.field;

import dev.boxadactle.boxlib.config.gui.BConfigTextField;

import java.util.function.Consumer;

public class BFloatField extends BConfigTextField<Float> {
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
