package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.BoxLib;
import dev.boxadactle.boxlib.math.Rect;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.MouseUtils;
import dev.boxadactle.boxlib.util.function.Converter;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public abstract class BConfigTextField<T> extends EditBox implements BConfigEntry<T>, BConfigHelper, Converter<T, String> {

    protected T currentValue;
    protected Consumer<T> function;

    protected boolean halfWidget = false;

    protected boolean hasInvalidValue = false;

    public BConfigTextField(T value, Consumer<T> function) {
        super(GuiUtils.getTextRenderer(), 0, 0, 200, 18, Component.literal("ConfigWidget"));

        currentValue = value;
        this.function = function;

        super.setResponder(this::onInput);
        super.insertText(this.from(value));
    }

    @Override
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        super.render(p_93657_, mouseX, mouseY, delta);

        if (this.isInvalid()) this.setTextColor(GuiUtils.RED);
        else this.setTextColor(14737632);
    }

    private void onInput(String input) {
        T a = this.to(input);
        if (a == null) return;
        this.handleInput(a);
    }

    protected void setInvalid(boolean a) {
        this.hasInvalidValue = a;
    }

    @Override
    public boolean isInvalid() {
        return hasInvalidValue;
    }

    @Override
    public T handleInput(T input) {
        this.function.accept(input);
        return input;
    }

    @Override
    public void setHalfWidget(boolean halfButton) {
        this.halfWidget = halfButton;
    }

    @Override
    public boolean isHalfWidget() {
        return halfWidget;
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
        if (!isHalfWidget()) {
            super.setWidth(width);
        } else {
            super.setWidth(width / 2);
        }
    }

    @Override
    public boolean isHovered() {
        return super.isHovered();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public Component getMessage() {
        return super.getMessage();
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        if (!MouseUtils.isMouseHovering(new Rect<>(this.getX(), this.getY(), this.width, this.height))) super.setFocused(false);
        BoxLib.LOGGER.info(!MouseUtils.isMouseHovering(new Rect<>(this.getX(), this.getY(), this.width, this.height)));
        super.onClick(mouseX, mouseY);
    }

    @Override
    public void tick() {
        super.tick();
    }

}
