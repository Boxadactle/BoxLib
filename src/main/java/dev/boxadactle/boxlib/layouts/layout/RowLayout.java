package dev.boxadactle.boxlib.layouts.layout;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;

/**
 * Represents a layout that arranges components in a row.
 */
public class RowLayout extends RenderingLayout {
    /**
     * Constructs a new RowLayout with the specified coordinates and padding.
     *
     * @param x       the x-coordinate of the layout
     * @param y       the y-coordinate of the layout
     * @param padding the padding between components
     */
    public RowLayout(int x, int y, int padding) {
        super(x, y, padding);
    }

    /**
     * Calculates and returns the width of the layout.
     *
     * @return the width of the layout
     */
    @Override
    protected int getWidth() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a += component.getWidth() + padding * 2;
        }

        a -= padding * 2;

        return a;
    }

    /**
     * Calculates and returns the height of the layout.
     *
     * @return the height of the layout
     */
    @Override
    protected int getHeight() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a = Math.max(a, component.getHeight());
        }

        return a;
    }

    /**
     * Renders the layout and its components on the specified graphics object.
     *
     * @param poseStack the PoseStack object used for rendering
     */
    @Override
    public void render(PoseStack poseStack) {
        final int[] currentX = {x};

        for (int i = 0; i < components.size(); i++) {
            LayoutComponent<?> component = components.get(i);
            component.render(poseStack, currentX[0], y);

            if (i != components.size() - 1) {
                currentX[0] += component.getWidth() + padding * 2;
            }
        }
    }
}
