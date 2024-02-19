package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class HorizontalLayout extends RenderingLayout {
    public HorizontalLayout(int x, int y, int padding) {
        super(x, y, padding);
    }

    @Override
    protected int getWidth() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a += component.getWidth() + padding * 2;
        }

        return a;
    }

    @Override
    protected int getHeight() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a = Math.max(a, component.getHeight());
        }


        return a + padding * 2;
    }

    @Override
    public void render(GuiGraphics graphics) {
        final int[] currentX = {x};

        components.forEach(component -> {
            component.render(graphics, currentX[0], y);

            currentX[0] += component.getWidth() + padding * 2;
        });
    }
}
