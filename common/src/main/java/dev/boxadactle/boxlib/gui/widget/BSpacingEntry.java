package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BOptionButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BSpacingEntry extends BOptionButton<Object> {
    public BSpacingEntry() {
        super(Component.literal(""), null, a -> {});
    }

    @Override
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
