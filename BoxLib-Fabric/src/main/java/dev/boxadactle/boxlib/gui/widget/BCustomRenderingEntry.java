package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigButton;
import dev.boxadactle.boxlib.util.function.Consumer8;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BCustomRenderingEntry extends BConfigButton<Object> {

    Consumer8<DrawContext, Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    public BCustomRenderingEntry(Consumer8<DrawContext, Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super(Text.of(""), null, null);

        this.function = function;
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        function.accept(drawContext, this.getX(), this.getY(), this.width, this.height, mouseX, mouseY, delta);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }

}
