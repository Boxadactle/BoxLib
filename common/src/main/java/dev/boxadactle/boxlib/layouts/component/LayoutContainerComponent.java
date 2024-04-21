package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

/**
 * Represents a layout container component that extends the LayoutComponent class.
 * It is responsible for rendering and calculating the width and height of the component.
 */
public class LayoutContainerComponent extends LayoutComponent<RenderingLayout> {
    /**
     * Constructs a LayoutContainerComponent with the specified RenderingLayout component.
     *
     * @param component the RenderingLayout component to be used by the container
     */
    public LayoutContainerComponent(RenderingLayout component) {
        super(component);
    }

    /**
     * Returns the width of the component.
     *
     * @return the width of the component
     */
    @Override
    public int getWidth() {
        return component.calculateRect().getWidth();
    }

    /**
     * Returns the height of the component.
     *
     * @return the height of the component
     */
    @Override
    public int getHeight() {
        return component.calculateRect().getHeight();
    }

    /**
     * Renders the component on the specified GuiGraphics at the given position.
     *
     * @param graphics the GuiGraphics object to render on
     * @param x        the x-coordinate of the position to render the component
     * @param y        the y-coordinate of the position to render the component
     */
    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        component.setPosition(x, y);
        component.render(graphics);
    }
}
