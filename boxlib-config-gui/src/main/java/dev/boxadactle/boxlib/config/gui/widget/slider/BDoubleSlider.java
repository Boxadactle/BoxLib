package dev.boxadactle.boxlib.config.gui.widget.slider;

import dev.boxadactle.boxlib.config.gui.BConfigSlider;
import dev.boxadactle.boxlib.math.mathutils.NumberFormatter;

import java.util.function.Consumer;

public class BDoubleSlider extends BConfigSlider<Double> {
    NumberFormatter<Double> formatter;

    public BDoubleSlider(String key, double min, double max, double value, int decimalPlaces, Consumer<Double> function) {
        super(key, min, max, value, function);

        formatter = new NumberFormatter<>(decimalPlaces);
    }

    @Override
    public Double to(Double input) {
        return input;
    }

    @Override
    public Double from(Double input) {
        return input;
    }

    @Override
    protected String roundNumber(Double input) {
        return formatter.formatDecimal(input);
    }
}