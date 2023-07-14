package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BLabel extends BConfigButton<Object> {

    Text message;

    public BLabel(Text message) {
        super(message, null, null);

        this.message = message;
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(drawContext, message, this.getX(), this.getY() + 5);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {

    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
