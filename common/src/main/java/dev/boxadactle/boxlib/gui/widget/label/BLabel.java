package dev.boxadactle.boxlib.gui.widget.label;

import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BLabel extends BOptionButton<Object> {

    protected Component message;

    public BLabel(Component message) {
        super(message, null, null);

        this.message = message;
    }

    @Override
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(p_93657_, message, this.getX(), this.getY() + 5);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {

    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
