package dev.boxadactle.boxlib.layouts;

import dev.boxadactle.boxlib.layouts.component.LayoutContainerComponent;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import net.minecraft.client.gui.GuiGraphics;

import java.util.ArrayList;
import java.util.List;

/**
 * The RenderingLayout class represents a layout used for rendering components on a graphical user interface (GUI).
 * It provides methods for positioning components, adding and removing components, and rendering the layout.
 */
public abstract class RenderingLayout {
    protected int x;
    protected int y;

    protected int padding;

    protected List<LayoutComponent<?>> components;

    /**
     * Gets the width of the layout.
     *
     * @return The width of the layout.
     */
    protected abstract int getWidth();

    /**
     * Gets the height of the layout.
     *
     * @return The height of the layout.
     */
    protected abstract int getHeight();

    /**
     * Renders the layout using the specified graphics object.
     *
     * @param graphics The graphics object used for rendering.
     */
    public abstract void render(GuiGraphics graphics);

    /**
     * Orders the components within the layout.
     * This method can be overridden by subclasses to define a specific order for the components.
     */
    protected void orderComponents() {
    }

    /**
     * Sets the position of the layout to the specified coordinates.
     *
     * @param x The x-coordinate of the layout.
     * @param y The y-coordinate of the layout.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the position of the layout to the specified position vector.
     *
     * @param position The position vector containing the x and y coordinates.
     */
    public void setPosition(Vec3<Integer> position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Calculates and returns the rectangular bounds of the layout.
     *
     * @return The rectangular bounds of the layout.
     */
    public Rect<Integer> calculateRect() {
        return new Rect<>(x, y, getWidth(), getHeight());
    }

    /**
     * @param component The component to be added.
     */
    public void addComponent(LayoutComponent<?> component) {
        components.add(component);
    }

    /**
     * Removes a component from the layout.
     *
     * @param component The component to be removed.
     */
    public void removeComponent(LayoutComponent<?> component) {
        components.remove(component);
    }

    /**
     * @param x       The x-coordinate of the layout.
     * @param y       The y-coordinate of the layout.
     * @param padding The padding around the components in the layout.
     */
    public RenderingLayout(int x, int y, int padding) {
        this.x = x;
        this.y = y;
        this.padding = padding;

        components = new ArrayList<>();
    }

    /**
     * Constructs a new RenderingLayout object with the specified position and no padding.
     *
     * @param x The x-coordinate of the layout.
     * @param y The y-coordinate of the layout.
     */
    public RenderingLayout(int x, int y) {
        this(x, y, 0);
    }
}
