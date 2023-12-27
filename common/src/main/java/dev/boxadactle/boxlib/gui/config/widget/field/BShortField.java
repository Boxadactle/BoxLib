package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

public class BShortField extends BOptionTextField<Short> {
    public BShortField(Short value, Consumer<Short> function) {
        super(value, function);
    }

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

    @Override
    public String from(Short input) {
        return Short.toString(input);
    }
}
