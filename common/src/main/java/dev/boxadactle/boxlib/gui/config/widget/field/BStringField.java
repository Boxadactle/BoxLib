package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

public class BStringField extends BOptionTextField<String> {
    public BStringField(String value, Consumer<String> function) {
        super(value, function);
    }

    @Override
    public String to(String input) {
        return input;
    }

    @Override
    public String from(String input) {
        return input;
    }
}
