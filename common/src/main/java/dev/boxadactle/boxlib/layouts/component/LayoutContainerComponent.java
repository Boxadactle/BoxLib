package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class LayoutContainerComponent extends LayoutComponent<RenderingLayout> {
    public LayoutContainerComponent(RenderingLayout component) {
        super(component);
    }

    @Override
    public int getWidth() {
        return component.calculateRect().getWidth();
    }

    @Override
    public int getHeight() {
        return component.calculateRect().getHeight();
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        component.setPosition(x, y);

        component.render(graphics);
    }
}
