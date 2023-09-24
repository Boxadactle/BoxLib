package dev.boxadactle.boxlib.gui.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

public class BLeftLabel extends BLabel {
    public BLeftLabel(Component message) {
        super(message);
    }

    @Override
    public void render(PoseStack guiGraphics, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(guiGraphics, message, this.x + this.getWidth() - GuiUtils.getTextRenderer().width(message), this.y + 5);
    }
}
