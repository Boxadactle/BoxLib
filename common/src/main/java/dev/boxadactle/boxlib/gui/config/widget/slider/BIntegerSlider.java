package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;

import java.util.function.Consumer;

public class BIntegerSlider extends BOptionSlider<Integer> {
    public BIntegerSlider(String key, int min, int max, int value, Consumer<Integer> function) {
        super(key, min, max, value, function);
    }

    @Override
    public Integer to(Double input) {
        return input.intValue();
    }

    @Override
    public Double from(Integer input) {
        return input.doubleValue();
    }

    @Override
    protected String roundNumber(Integer input) {
        return Integer.toString(input);
    }
}
