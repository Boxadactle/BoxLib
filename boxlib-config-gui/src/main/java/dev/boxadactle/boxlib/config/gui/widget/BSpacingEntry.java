package dev.boxadactle.boxlib.config.gui.widget;

import dev.boxadactle.boxlib.config.gui.BConfigButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BSpacingEntry extends BConfigButton<Object> {
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
