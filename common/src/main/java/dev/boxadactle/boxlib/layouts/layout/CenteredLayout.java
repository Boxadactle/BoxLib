package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

/**
 * A layout that centers its child layout within a specified width and height.
 */
public class CenteredLayout extends RenderingLayout {
    RenderingLayout layout;

    int width;
    int height;

    /**
     * Constructs a CenteredLayout with the specified position, width, height, and child layout.
     *
     * @param x      the x-coordinate of the layout's position
     * @param y      the y-coordinate of the layout's position
     * @param width  the width of the layout
     * @param height the height of the layout
     * @param layout the child layout to be centered
     */
    public CenteredLayout(int x, int y, int width, int height, RenderingLayout layout) {
        super(x, y, 0);

        this.layout = layout;
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    public void render(GuiGraphics graphics) {
        int childWidth = layout.calculateRect().getWidth();
        int childHeight = layout.calculateRect().getHeight();

        int childX = x + (width - childWidth) / 2;
        int childY = y + (height - childHeight) / 2;

        layout.setPosition(childX, childY);
        layout.render(graphics);
    }
}
