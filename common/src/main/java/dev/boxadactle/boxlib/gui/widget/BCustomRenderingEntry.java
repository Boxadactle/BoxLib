package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.function.Consumer8;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class BCustomRenderingEntry extends BOptionButton<Object> {

    protected Consumer8<GuiGraphics, Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    public BCustomRenderingEntry(Consumer8<GuiGraphics, Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super(Component.literal(""), null, null);

        this.function = function;
    }

    @Override
    public void render(GuiGraphics p_93657_, int mouseX, int mouseY, float delta) {
        function.accept(p_93657_, this.getX(), this.getY(), this.width, this.height, mouseX, mouseY, delta);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }

}
