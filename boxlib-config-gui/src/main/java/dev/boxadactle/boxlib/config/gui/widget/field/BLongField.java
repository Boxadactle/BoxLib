package dev.boxadactle.boxlib.config.gui.widget.field;

import dev.boxadactle.boxlib.config.gui.BConfigTextField;

import java.util.function.Consumer;

public class BLongField extends BConfigTextField<Long> {
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
