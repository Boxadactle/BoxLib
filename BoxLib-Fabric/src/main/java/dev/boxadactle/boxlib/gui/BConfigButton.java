package dev.boxadactle.boxlib.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public abstract class BConfigButton<T> extends ButtonWidget implements BConfigEntry<T>, BConfigHelper {

    protected Consumer<T> function;
    protected T currentValue;

    protected boolean halfButton = false;

    public BConfigButton(Text message, T value, Consumer<T> function) {
        super(0, 0, 10, BConfigHelper.buttonHeight(), message, b -> {}, DEFAULT_NARRATION_SUPPLIER);

        this.function = function;
        this.currentValue = value;
    }

    protected abstract T changeValue(T input);

    @Override
    public T handleInput(T input) {
        return this.changeValue(input);
    }

    @Override
    public void setHalfWidget(boolean halfButton) {
        this.halfButton = halfButton;
    }

    @Override
    public boolean isHalfWidget() {
        return halfButton;
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);

        this.function.accept(this.handleInput(currentValue));
    }

    @Override
    public void setWidth(int width) {
        if (!isHalfWidget()) {
            super.setWidth(width);
        } else {
            super.setWidth(width / 2);
        }
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        super.render(drawContext, mouseX, mouseY, delta);
    }

    @Override
    public boolean isInvalid() {
        return false;
    }
}
