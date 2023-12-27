package dev.boxadactle.boxlib.gui.config;

import net.minecraft.client.gui.GuiGraphics;
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
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public boolean isHovered() {
        return super.isHovered;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void renderWidget(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        super.renderWidget(p_93657_, mouseX, mouseY, delta);
    }
}
