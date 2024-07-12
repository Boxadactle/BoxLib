package dev.boxadactle.boxlib.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public class CenteredLabelWidget extends AbstractWidget {
    int color;

    public CenteredLabelWidget(int i, int j, int k, int l, Component component, int color) {
        super(i, j, k, l, component);

        this.color = color;
    }

    public CenteredLabelWidget(int i, int j, int k, int l, Component component) {
        this(i, j, k, l, component, GuiUtils.WHITE);
    }

    @Override
    public void renderWidget(PoseStack graphics, int i, int j, float f) {
        RenderUtils.drawTextCentered(graphics, getMessage(), getX() + width / 2, getY());
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        this.defaultButtonNarrationText(narrationElementOutput);
    }
}
