package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class ColumnLayout extends RenderingLayout {
    public ColumnLayout(int x, int y, int padding) {
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

        for (int i = 0; i < components.size(); i++) {
            LayoutComponent<?> component = components.get(i);
            component.render(graphics, x, currentY[0]);

            if (i != components.size() - 1) {
                currentY[0] += component.getHeight() + padding * 2;
            }
        }
    }
}
