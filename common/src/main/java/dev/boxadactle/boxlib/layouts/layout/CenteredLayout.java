package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class CenteredLayout extends RenderingLayout {
    RenderingLayout layout;

    int width;
    int height;

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
