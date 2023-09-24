package dev.boxadactle.boxlib.gui.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.BOptionButton;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

public class BLabel extends BOptionButton<Object> {

    Component message;

    public BLabel(Component message) {
        super(message, null, null);

        this.message = message;
    }

    @Override
    public void render(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(p_93657_, message, this.x, this.y + 5);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {

    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
