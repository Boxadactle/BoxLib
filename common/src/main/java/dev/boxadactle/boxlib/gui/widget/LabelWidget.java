package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public class LabelWidget extends AbstractWidget {
    int color;

    public LabelWidget(int i, int j, Component component, int color) {
        super(i, j, GuiUtils.getTextLength(component), GuiUtils.getTextHeight(), component);
        this.color = color;
    }

    public LabelWidget(int i, int j, Component component) {
        this(i, j, component, GuiUtils.WHITE);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int i, int j, float f) {
        RenderUtils.drawText(guiGraphics, this.getMessage(), this.getX(), this.getY(), 14737632);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
        this.defaultButtonNarrationText(narrationElementOutput);
    }
}
