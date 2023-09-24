package dev.boxadactle.boxlib.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.function.Converter;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public abstract class BOptionTextField<T> extends EditBox implements BOptionEntry<T>, BOptionHelper, Converter<T, String> {

    protected T currentValue;
    protected Consumer<T> function;

    protected boolean hasInvalidValue = false;

    public BOptionTextField(T value, Consumer<T> function) {
        super(GuiUtils.getTextRenderer(), 0, 0, 200, 18, Component.literal("ConfigWidget"));

        currentValue = value;
        this.function = function;

        super.setResponder(this::onInput);
        super.insertText(this.from(value));
    }

    @Override
    public void render(PoseStack poseStack, int i, int j, float f) {
        super.render(poseStack, i, j, f);

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
    public Component getMessage() {
        return super.getMessage();
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        if (!MouseUtils.isMouseHovering(new Rect<>(this.getX(), this.getY(), this.width, this.height))) super.setFocused(false);
        super.onClick(mouseX, mouseY);
    }

    @Override
    public void tick() {
        super.tick();
    }

}
