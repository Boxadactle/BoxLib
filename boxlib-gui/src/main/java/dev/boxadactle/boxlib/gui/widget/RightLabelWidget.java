package dev.boxadactle.boxlib.gui.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

public class RightLabelWidget extends AbstractWidget {
    int color;

    public RightLabelWidget(int i, int j, int k, int l, String component, int color) {
        super(i, j, k, l, component);

        this.color = color;
    }

    public RightLabelWidget(int i, int j, int k, int l, String component) {
        this(i, j, k, l, component, GuiUtils.WHITE);
    }

    @Override
    public void renderButton(int i, int j, float f) {
        RenderUtils.drawText(getMessage(), x + getWidth() - GuiUtils.getTextRenderer().width(getMessage()), y);
    }
}
