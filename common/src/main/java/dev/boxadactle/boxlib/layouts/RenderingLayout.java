package dev.boxadactle.boxlib.layouts;

import dev.boxadactle.boxlib.layouts.component.LayoutContainerComponent;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import net.minecraft.client.gui.GuiGraphics;

import java.util.ArrayList;
import java.util.List;

public abstract class RenderingLayout {
    protected int x;
    protected int y;

    protected int padding;

    protected List<LayoutComponent<?>> components;

    protected abstract int getWidth();

    protected abstract int getHeight();

    public abstract void render(GuiGraphics graphics);

    protected void orderComponents() {
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Vec3<Integer> position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public Rect<Integer> calculateRect() {
        return new Rect<>(x, y, getWidth(), getHeight());
    }

    public void addComponent(LayoutComponent<?> component) {
        components.add(component);
        orderComponents();
    }

    public void removeComponent(LayoutComponent<?> component) {
        components.remove(component);
    }

    public RenderingLayout(int x, int y, int padding) {
        this.x = x;
        this.y = y;
        this.padding = padding;

        components = new ArrayList<>();
    }

    public RenderingLayout(int x, int y) {
        this(x, y, 0);
    }
}
