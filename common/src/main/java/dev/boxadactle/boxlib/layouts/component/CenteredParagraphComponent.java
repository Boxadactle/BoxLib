package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class CenteredParagraphComponent extends ParagraphComponent {
    public CenteredParagraphComponent(int textPadding, Component... components) {
        super(textPadding, components);
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;
        int calculatedWidth = this.getWidth();

        for (Component component : this.component) {
            graphics.drawCenteredString(GuiUtils.getTextRenderer(), component, x + calculatedWidth / 2, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
