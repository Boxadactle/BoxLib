package dev.boxadactle.boxlib.gui.config.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

/**
 * The BLeftLabel class represents a left-aligned label widget in a graphical user interface.
 * It extends the BLabel class and provides a method to render the label on the screen.
 */
public class BRightLabel extends BLabel {
    /**
     * Constructs a new BLeftLabel with the specified message.
     *
     * @param message the text to be displayed on the label
     */
    public BRightLabel(Component message) {
        super(message);
    }

    /**
     * Renders the label on the screen.
     *
     * @param stack       the PoseStack instance
     * @param mouseX      the x-coordinate of the mouse cursor
     * @param mouseY      the y-coordinate of the mouse cursor
     * @param delta       the time since the last frame update
     */
    @Override
    public void renderButton(PoseStack stack, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(stack, message, this.x + this.getWidth() - GuiUtils.getTextRenderer().width(message), this.y + 5);
    }
}
