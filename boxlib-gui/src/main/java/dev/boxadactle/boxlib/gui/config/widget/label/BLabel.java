package dev.boxadactle.boxlib.gui.config.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

/**
 * A custom label widget for GUIs.
 */
public class BLabel extends BOptionButton<Object> {

    protected Component message;

    /**
     * Constructs a new BLabel with the specified message.
     *
     * @param message the label's message
     */
    public BLabel(Component message) {
        super(message, null, null);

        this.message = message;
    }

    @Override
    public void renderWidget(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(p_93657_, message, this.getX(), this.getY() + 5);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {

    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
