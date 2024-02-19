package dev.boxadactle.boxlib.layouts;

import dev.boxadactle.boxlib.math.geometry.Dimension;
import net.minecraft.client.gui.GuiGraphics;

public abstract class LayoutComponent<T> {

    protected T component;

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract void render(GuiGraphics graphics, int x, int y);

    public void setComponent(T component) {
        this.component = component;
    }

    public T getComponent() {
        return component;
    }

    public LayoutComponent(T component) {
        this.component = component;
    }
}
