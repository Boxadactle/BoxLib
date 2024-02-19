package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class StringComponent extends LayoutComponent<String> {

    public StringComponent(String component) {
        super(component);
    }

    @Override
    public int getWidth() {
        return GuiUtils.getTextLength(Component.literal(this.component));
    }

    @Override
    public int getHeight() {
        return GuiUtils.getTextHeight();
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        RenderUtils.drawText(graphics, Component.literal(this.component), x, y);
    }
}
