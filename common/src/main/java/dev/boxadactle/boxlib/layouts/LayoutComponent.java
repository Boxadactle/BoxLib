package dev.boxadactle.boxlib.layouts;

import net.minecraft.client.gui.GuiGraphics;

/**
 * The abstract base class for layout components.
 *
 * @param <T> the type of the component
 */
public abstract class LayoutComponent<T> {

    protected T component;

    /**
     * Gets the width of the layout component.
     *
     * @return the width of the layout component
     */
    public abstract int getWidth();

    /**
     * Gets the height of the layout component.
     *
     * @return the height of the layout component
     */
    public abstract int getHeight();

    /**
     * Renders the layout component on the screen.
     *
     * @param graphics the graphics object used for rendering
     * @param x        the x-coordinate of the component's position
     * @param y        the y-coordinate of the component's position
     */
    public abstract void render(GuiGraphics graphics, int x, int y);

    /**
     * Sets the component for the layout component.
     *
     * @param component the component to set
     */
    public void setComponent(T component) {
        this.component = component;
    }

    /**
     * Gets the component of the layout component.
     *
     * @return the component of the layout component
     */
    public T getComponent() {
        return component;
    }

    /**
     * Constructs a new layout component with the specified component.
     *
     * @param component the component for the layout component
     */
    public LayoutComponent(T component) {
        this.component = component;
    }
}
