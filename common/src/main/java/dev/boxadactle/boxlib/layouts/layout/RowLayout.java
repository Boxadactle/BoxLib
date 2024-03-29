package dev.boxadactle.boxlib.layouts.layout;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.layouts.RenderingLayout;
import net.minecraft.client.gui.GuiGraphics;

public class RowLayout extends RenderingLayout {
    public RowLayout(int x, int y, int padding) {
        super(x, y, padding);
    }

    @Override
    protected int getWidth() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a += component.getWidth() + padding * 2;
        }

        a -= padding * 2;

        return a;
    }

    @Override
    protected int getHeight() {
        int a = 0;

        for (LayoutComponent<?> component : components) {
            a = Math.max(a, component.getHeight());
        }

        return a;
    }

    @Override
    public void render(GuiGraphics graphics) {
        final int[] currentX = {x};

        for (int i = 0; i < components.size(); i++) {
            LayoutComponent<?> component = components.get(i);
            component.render(graphics, currentX[0], y);

            if (i != components.size() - 1) {
                currentX[0] += component.getWidth() + padding * 2;
            }
        }
    }
}
