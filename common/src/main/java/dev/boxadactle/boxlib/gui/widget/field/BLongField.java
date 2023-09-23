package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

public class BLongField extends BOptionTextField<Long> {
    public BLongField(Long value, Consumer<Long> function) {
        super(value, function);
    }

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

    @Override
    public String from(Long input) {
        return Long.toString(input);
    }
}
