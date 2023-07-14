package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigTextField;

import java.util.function.Consumer;

public class BHexField extends BConfigTextField<Integer> {
    public BHexField(Integer value, Consumer<Integer> function) {
        super(value, function);

        this.setMaxLength(6);
    }

    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.valueOf(input.replaceAll("#", ""), 16);
            this.setInvalid(false);
            return a;
        } catch (NumberFormatException ignored) {
            this.setInvalid(true);
            return null;
        }
    }

    @Override
    public String from(Integer input) {
        return Integer.toHexString(input);
    }
}
