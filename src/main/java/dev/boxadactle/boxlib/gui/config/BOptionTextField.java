package dev.boxadactle.boxlib.gui.config;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.MouseUtils;
import dev.boxadactle.boxlib.function.Converter;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import java.util.function.Consumer;

/**
 * Represents a text field option in a GUI.
 * This class extends the EditBox class and implements the BOptionEntry, BOptionHelper, and Converter interfaces.
 * It provides functionality for handling user input, rendering the text field, and validating the input value.
 *
 * @param <T> the type of the option value
 */
public abstract class BOptionTextField<T> extends EditBox implements BOptionEntry<T>, BOptionHelper, Converter<T, String> {

    protected T currentValue;
    protected Consumer<T> function;

    protected boolean hasInvalidValue = false;

    public BOptionTextField(T value, Consumer<T> function) {
        super(GuiUtils.getTextRenderer(), 0, 0, 200, 18, new TextComponent("ConfigWidget"));

        currentValue = value;
        this.function = function;

        super.setResponder(this::onInput);
        super.insertText(this.from(value));
    }

    @Override
    public void renderButton(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        super.renderButton(p_93657_, mouseX, mouseY, delta);

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
    public void setWidth(int width) {
        super.setWidth(width);
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
        if (!MouseUtils.isMouseHovering(new Rect<>(this.x, this.y, this.width, this.height))) super.setFocused(false);
        super.onClick(mouseX, mouseY);
    }

}
