package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigTextField;

import java.util.function.Consumer;

public class BArgbField extends BConfigTextField<Integer> {
    public BArgbField(Integer value, Consumer<Integer> function) {
        super(value, function);
    }

    @Override
    public Integer to(String input) {
        try {
            Integer a = Integer.parseUnsignedInt(input.replaceAll("#", ""), 16);
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
