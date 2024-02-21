package dev.boxadactle.boxlib.gui.config.widget.slider;

import dev.boxadactle.boxlib.gui.config.BOptionSlider;
import dev.boxadactle.boxlib.math.mathutils.NumberFormatter;

import java.util.function.Consumer;

public class BFloatSlider extends BOptionSlider<Float> {
    protected NumberFormatter<Float> formatter;

    public BFloatSlider(String key, float min, float max, float value, int decimalPlaces, Consumer<Float> function) {
        super(key, min, max, value, function);

        formatter = new NumberFormatter<>(decimalPlaces);
    }

    @Override
    public Float to(Double input) {
        return input.floatValue();
    }

    @Override
    public Double from(Float input) {
        return input.doubleValue();
    }

    @Override
    protected String roundNumber(Float input) {
        return formatter.formatDecimal(input);
    }
}
