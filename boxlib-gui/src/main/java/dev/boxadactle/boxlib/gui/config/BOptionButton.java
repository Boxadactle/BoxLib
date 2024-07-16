package dev.boxadactle.boxlib.gui.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

/**
 * This class represents a button option in the GUI.
 * It extends the Button class and implements BOptionEntry and BOptionHelper interfaces.
 * It provides methods to handle input, change value, and render the button.
 *
 * @param <T> the type of the value that this button handles
 */
public abstract class BOptionButton<T> extends Button implements BOptionEntry<T>, BOptionHelper {

    /**
     * A function that consumes the current value.
     */
    protected Consumer<T> function;

    /**
     * The current value of the button.
     */
    protected T currentValue;

    /**
     * Constructs a new BOptionButton with the given message, value, and function.
     *
     * @param message the message to display on the button
     * @param value the initial value of the button
     * @param function the function to consume the current value
     */
    public BOptionButton(String message, T value, Consumer<T> function) {
        super(0, 0, 10, BOptionHelper.buttonHeight(), message, b -> {});

        this.function = function;
        this.currentValue = value;
    }

    /**
     * Changes the value of the button.
     *
     * @param input the new value to set
     * @return the changed value
     */
    protected abstract T changeValue(T input);

    /**
     * Handles the input for the button.
     *
     * @param input the input to handle
     * @return the result of handling the input
     */
    @Override
    public T handleInput(T input) {
        return this.changeValue(input);
    }

    /**
     * Handles the click event for the button.
     *
     * @param mouseX the x-coordinate of the mouse click
     * @param mouseY the y-coordinate of the mouse click
     */
    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);

        this.function.accept(this.handleInput(currentValue));
    }

    /**
     * Sets the width of the button.
     *
     * @param width the new width
     */
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float delta) {
        super.renderButton(mouseX, mouseY, delta);
    }

    /**
     * Checks if the button is invalid.
     *
     * @return false as the button is never invalid
     */
    @Override
    public boolean isInvalid() {
        return false;
    }
}
