package dev.boxadactle.boxlib.gui.config.widget.label;

import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BCenteredLabel extends BLabel {

    public BCenteredLabel(Component message) {
        super(message);
    }

    @Override
    public void renderWidget(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        RenderUtils.drawTextCentered(p_93657_, message, this.getX() + this.width / 2, this.getY() + 5);
    }
}
