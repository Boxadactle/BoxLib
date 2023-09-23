package dev.boxadactle.boxlib.gui.widget.slider;

import dev.boxadactle.boxlib.gui.BOptionSlider;

import java.util.function.Consumer;

public class BLongSlider extends BOptionSlider<Long> {
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
