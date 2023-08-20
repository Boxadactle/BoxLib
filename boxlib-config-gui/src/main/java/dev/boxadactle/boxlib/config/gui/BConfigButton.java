package dev.boxadactle.boxlib.config.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public abstract class BConfigButton<T> extends Button implements BConfigEntry<T>, BConfigHelper {

    protected Consumer<T> function;
    protected T currentValue;

    public BConfigButton(Component message, T value, Consumer<T> function) {
        super(0, 0, 10, BConfigHelper.buttonHeight(), message, b -> {}, DEFAULT_NARRATION);

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
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        super.render(p_93657_, mouseX, mouseY, delta);
    }

    @Override
    public boolean isInvalid() {
        return false;
    }
}
