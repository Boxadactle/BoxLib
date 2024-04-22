package dev.boxadactle.boxlib.gui.config;

import net.minecraft.client.gui.GuiGraphics;
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
    public BOptionButton(Component message, T value, Consumer<T> function) {
        super(0, 0, 10, BOptionHelper.buttonHeight(), message, b -> {}, DEFAULT_NARRATION);

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
     * Sets the x-coordinate of the button.
     *
     * @param x the new x-coordinate
     */
    @Override
    public void setX(int x) {
        super.setX(x);
    }

    /**
     * Sets the y-coordinate of the button.
     *
     * @param y the new y-coordinate
     */
    @Override
    public void setY(int y) {
        super.setY(y);
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

    /**
     * Checks if the button is hovered.
     *
     * @return true if the button is hovered, false otherwise
     */
    @Override
    public boolean isHovered() {
        return super.isHovered;
    }

    /**
     * Handles the mouse click event.
     *
     * @param mouseX the x-coordinate of the mouse click
     * @param mouseY the y-coordinate of the mouse click
     * @param button the mouse button that was clicked
     * @return true if the event was handled, false otherwise
     */
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return super.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * Renders the button.
     *
     * @param p_93657_ the GuiGraphics object used for rendering
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param delta the time difference between the last and current frame
     */
    @Override
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        super.render(p_93657_, mouseX, mouseY, delta);
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
