package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class LeftParagraphComponent extends ParagraphComponent {
    public LeftParagraphComponent(int textPadding, Component... components) {
        super(textPadding, components);
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;
        int thisWidth = getWidth();

        for (Component component : this.component) {
            int width = GuiUtils.getTextLength(component);
            graphics.drawString(GuiUtils.getTextRenderer(), component, x + thisWidth - width, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
