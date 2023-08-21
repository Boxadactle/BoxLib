package dev.boxadactle.boxlib.config.gui.widget.slider;

import dev.boxadactle.boxlib.config.gui.BConfigSlider;

import java.util.function.Consumer;

public class BShortSlider extends BConfigSlider<Short> {
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
