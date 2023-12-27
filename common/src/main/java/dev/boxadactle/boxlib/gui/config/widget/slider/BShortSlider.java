package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;

import java.util.function.Consumer;

public class BShortSlider extends BOptionSlider<Short> {
    public BShortSlider(String key, short min, short max, short value, Consumer<Short> function) {
        super(key, min, max, value, function);
    }

    @Override
    public Short to(Double input) {
        return input.shortValue();
    }

    @Override
    public Double from(Short input) {
        return input.doubleValue();
    }

    @Override
    protected String roundNumber(Short input) {
        return Short.toString(input);
    }
}
