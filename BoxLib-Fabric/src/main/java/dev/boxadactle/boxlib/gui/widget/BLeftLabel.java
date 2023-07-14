package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BLeftLabel extends BLabel {
    public BLeftLabel(Text message) {
        super(message);
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(drawContext, message, this.getX() + this.getWidth() - GuiUtils.getTextRenderer().getWidth(message), this.getY() + 5);
    }
}
