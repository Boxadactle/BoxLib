package dev.boxadactle.boxlib.config.gui;

import dev.boxadactle.boxlib.base.BoxLib;
import dev.boxadactle.boxlib.math.mathutils.Mappers;
import dev.boxadactle.boxlib.util.function.Converter;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public abstract class BConfigSlider<T extends Number> extends AbstractSliderButton implements BConfigEntry<T>, Converter<T, Double> {
    T min;
    T max;

    String key;

    Consumer<T> function;

    public BConfigSlider(String key, T min, T max, T value, Consumer<T> function) {
        super(
                0, 0, 10, BConfigHelper.buttonHeight(),
                Component.translatable(key, value),
                0.0d
        );

        this.min = min;
        this.max = max;

        this.key = key;

        this.function = function;

        this.value = calculateSliderPos(from(value));
    }

    private Double calculateSliderPos(Double value) {
        double newMax = from(max);
        double newMin = from(min);

        return Mappers.normalizeMap(value, newMin, newMax);
    }

    private Double calculateValue() {
        double newMax = from(max);
        double newMin = from(min);

        return Mappers.map(value, newMin, newMax);
    }

    @Override
    public T handleInput(T input) {
        T newVal = to(calculateValue());

        function.accept(newVal);

        return newVal;
    }

    protected abstract String roundNumber(T input);

    @Override
    protected void updateMessage() {
        setMessage(Component.translatable(key, roundNumber(to(calculateValue()))));
    }

    @Override
    protected void applyValue() {
        handleInput(to(value));
    }
}
