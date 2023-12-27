package dev.boxadactle.boxlib.gui.config.widget.label;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BRightLabel extends BLabel {
    public BRightLabel(Component message) {
        super(message);
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(guiGraphics, message, this.getX() + this.getWidth() - GuiUtils.getTextRenderer().width(message), this.getY() + 5);
    }
}
