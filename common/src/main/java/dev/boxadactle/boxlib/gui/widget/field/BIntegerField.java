package dev.boxadactle.boxlib.gui.widget.field;

import dev.boxadactle.boxlib.gui.BOptionTextField;

import java.util.function.Consumer;

public class BIntegerField extends BOptionTextField<Integer> {
    public BIntegerField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.parseInt(input);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }

    }

    @Override
    public String from(Integer input) {
        return Integer.toString(input);
    }
}
