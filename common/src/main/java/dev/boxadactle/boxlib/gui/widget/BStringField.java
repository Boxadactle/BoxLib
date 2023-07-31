package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigTextField;

import java.util.function.Consumer;

public class BStringField extends BConfigTextField<String> {
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