package dev.boxadactle.boxlib.gui.config.widget;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BSpacingEntry extends BOptionButton<Object> {
    public BSpacingEntry() {
        super(Component.literal(""), null, a -> {});
    }

    @Override
    public void renderWidget(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
