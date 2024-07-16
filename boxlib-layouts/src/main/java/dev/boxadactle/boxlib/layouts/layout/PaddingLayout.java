package dev.boxadactle.boxlib.layouts.layout;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.layouts.RenderingLayout;

/**
 * The `PaddingLayout` class represents a layout that adds padding around a child layout.
 * It extends the `RenderingLayout` class and provides methods to set the child layout and padding.
 */
public class PaddingLayout extends RenderingLayout {
    RenderingLayout layout;

    /**
     * Constructs a new `PaddingLayout` with the specified position, padding, and child layout.
     *
     * @param x      the x-coordinate of the layout's position
     * @param y      the y-coordinate of the layout's position
     * @param padding the padding value to be added around the child layout
     * @param layout the child layout to be wrapped with padding
     */
    public PaddingLayout(int x, int y, int padding, RenderingLayout layout) {
        super(x, y, padding);

        this.layout = layout;
    }

    /**
     * Sets the child layout of this `PaddingLayout`.
     *
     * @param layout the child layout to be set
     */
    public void setLayout(RenderingLayout layout) {
        this.layout = layout;
    }

    /**
     * Sets the padding value of this `PaddingLayout`.
     *
     * @param padding the padding value to be set
     */
    public void setPadding(int padding) {
        this.padding = padding;
    }

    @Override
    protected int getWidth() {
        return layout.calculateRect().getWidth() + padding * 2;
    }

    @Override
    protected int getHeight() {
        return layout.calculateRect().getHeight() + padding * 2;
    }

    @Override
    public void render() {
        layout.setPosition(x + padding, y + padding);

        layout.render();
    }
}
