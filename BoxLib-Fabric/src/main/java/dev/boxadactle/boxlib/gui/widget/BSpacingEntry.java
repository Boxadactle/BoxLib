package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BSpacingEntry extends BConfigButton<Object> {
    public BSpacingEntry() {
        super(Text.of(""), null, a -> {});
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
