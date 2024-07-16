package dev.boxadactle.boxlib.gui.config.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.util.RenderUtils;

/**
 * A custom label widget for GUIs.
 */
public class BLabel extends BOptionButton<Object> {

    protected String message;

    /**
     * Constructs a new BLabel with the specified message.
     *
     * @param message the label's message
     */
    public BLabel(String message) {
        super(message, null, null);

        this.message = message;
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(message, this.x, this.y + 5);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {

    }

    @Override
    protected Object changeValue(Object input) {
        return null;
    }
}
