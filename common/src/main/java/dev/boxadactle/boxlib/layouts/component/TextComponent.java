package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class TextComponent extends LayoutComponent<Component> {

    public TextComponent(Component component) {
        super(component);
    }

    @Override
    public int getWidth() {
        return GuiUtils.getTextLength(this.component);
    }

    @Override
    public int getHeight() {
        return GuiUtils.getTextHeight();
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        RenderUtils.drawText(graphics, this.component, x, y);
    }
}
