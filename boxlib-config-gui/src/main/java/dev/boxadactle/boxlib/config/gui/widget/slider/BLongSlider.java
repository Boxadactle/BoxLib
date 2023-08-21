package dev.boxadactle.boxlib.config.gui.widget.slider;

import dev.boxadactle.boxlib.config.gui.BConfigSlider;

import java.util.function.Consumer;

public class BLongSlider extends BConfigSlider<Long> {
    public BLongSlider(String key, long min, long max, long value, Consumer<Long> function) {
        super(key, min, max, value, function);
    }

    @Override
    public Long to(Double input) {
        return input.longValue();
    }

    @Override
    public Double from(Long input) {
        return input.doubleValue();
    }

    @Override
    protected String roundNumber(Long input) {
        return Long.toString(input);
    }
}
