package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BCenteredLabel extends BLabel {

    public BCenteredLabel(Text message) {
        super(message);
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        RenderUtils.drawTextCentered(drawContext, message, this.getX() + this.width / 2, this.getY() + 5);
    }
}
