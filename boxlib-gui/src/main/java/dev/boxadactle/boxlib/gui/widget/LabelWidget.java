package dev.boxadactle.boxlib.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

public class LabelWidget extends AbstractWidget {
    int color;

    public LabelWidget(int i, int j, Component component, int color) {
        super(i, j, GuiUtils.getTextSize(component), GuiUtils.getTextHeight(), component);
        this.color = color;
    }

    public LabelWidget(int i, int j, Component component) {
        this(i, j, component, GuiUtils.WHITE);
    }

    @Override
    public void renderButton(PoseStack stack, int i, int j, float f) {
        RenderUtils.drawText(stack, this.getMessage(), this.x, this.y, 14737632);
    }
}
