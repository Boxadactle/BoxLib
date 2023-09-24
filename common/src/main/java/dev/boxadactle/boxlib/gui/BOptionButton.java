package dev.boxadactle.boxlib.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public abstract class BOptionButton<T> extends Button implements BOptionEntry<T>, BOptionHelper {

    protected Consumer<T> function;
    protected T currentValue;

    public BOptionButton(Component message, T value, Consumer<T> function) {
        super(0, 0, 10, BOptionHelper.buttonHeight(), message, b -> {}, DEFAULT_NARRATION);

        this.function = function;
        this.currentValue = value;
    }

    protected abstract T changeValue(T input);

    @Override
    public T handleInput(T input) {
        return this.changeValue(input);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);

        this.function.accept(this.handleInput(currentValue));
    }

    @Override
    public boolean isInvalid() {
        return false;
    }
}
