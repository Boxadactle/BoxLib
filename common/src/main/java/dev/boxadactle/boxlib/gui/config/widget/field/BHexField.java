package dev.boxadactle.boxlib.gui.config.widget.field;

import dev.boxadactle.boxlib.gui.config.BOptionTextField;

import java.util.function.Consumer;

public class BHexField extends BOptionTextField<Integer> {
    public BHexField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.valueOf(input.replaceAll("#", ""), 16);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException e) {
            this.setInvalid(true);
            return null;
        }
    }

    @Override
    public String from(Integer input) {
        return Integer.toHexString(input);
    }
}
