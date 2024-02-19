package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class PaddingLayout extends RenderingLayout {
    RenderingLayout layout;

    public PaddingLayout(int x, int y, int padding, RenderingLayout layout) {
        super(x, y, padding);

        this.layout = layout;
    }

    @Override
    public void addComponent(LayoutComponent<?> component) {
        throw new UnsupportedOperationException("PaddingLayout does not support adding components. Please use setLayout method");
    }

    public void setLayout(RenderingLayout layout) {
        this.layout = layout;
    }

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
    public void render(GuiGraphics graphics) {
        layout.setPosition(x + padding, y + padding);

        layout.render(graphics);
    }
}
