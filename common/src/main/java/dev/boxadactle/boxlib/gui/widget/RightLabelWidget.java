package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public class RightLabelWidget extends AbstractWidget {
    int color;

    public RightLabelWidget(int i, int j, int k, int l, Component component, int color) {
        super(i, j, k, l, component);

        this.color = color;
    }

    public RightLabelWidget(int i, int j, int k, int l, Component component) {
        this(i, j, k, l, component, GuiUtils.WHITE);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int i, int j, float f) {
        RenderUtils.drawText(guiGraphics, getMessage(), getX() + getWidth() - GuiUtils.getTextRenderer().width(getMessage()), getY());
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
