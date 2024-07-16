package dev.boxadactle.boxlib.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.AbstractWidget;

public class LabelWidget extends AbstractWidget {
    int color;

    public LabelWidget(int i, int j, String component, int color) {
        super(i, j, GuiUtils.getTextSize(component), GuiUtils.getTextHeight(), component);
        this.color = color;
    }

    public LabelWidget(int i, int j, String component) {
        this(i, j, component, GuiUtils.WHITE);
    }

    @Override
    public void renderButton(int i, int j, float f) {
        RenderUtils.drawText(this.getMessage(), this.x, this.y, 14737632);
    }
}
