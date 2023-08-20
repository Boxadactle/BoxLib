package dev.boxadactle.boxlib.config.gui.widget;

import dev.boxadactle.boxlib.config.gui.BConfigTextField;

import java.util.function.Consumer;

public class BHexField extends BConfigTextField<Integer> {
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
