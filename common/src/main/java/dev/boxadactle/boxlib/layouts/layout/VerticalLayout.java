package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class VerticalLayout extends RenderingLayout {
    public VerticalLayout(int x, int y, int padding) {
        super(x, y, padding);
    }

    @Override
    protected int getWidth() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a = Math.max(a, component.getWidth());
        }

        return a + padding * 2;
    }

    @Override
    protected int getHeight() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a += component.getHeight() + padding * 2;
        }

        return a;
    }

    @Override
    public void render(GuiGraphics graphics) {
        final int[] currentY = {y};

        components.forEach(component -> {
            component.render(graphics, x, currentY[0]);

            currentY[0] += component.getHeight() + padding * 2;
        });
    }
}
