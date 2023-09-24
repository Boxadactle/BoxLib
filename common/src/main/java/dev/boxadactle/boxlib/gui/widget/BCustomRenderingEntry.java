package dev.boxadactle.boxlib.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.function.Consumer8;
import dev.boxadactle.boxlib.gui.BOptionButton;
import net.minecraft.network.chat.Component;

public class BCustomRenderingEntry extends BOptionButton<Object> {

    Consumer8<PoseStack, Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    public BCustomRenderingEntry(Consumer8<PoseStack, Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super(Component.literal(""), null, null);

        this.function = function;
    }

    @Override
    public void render(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        function.accept(p_93657_, this.x, this.y, this.width, this.height, mouseX, mouseY, delta);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }

}
