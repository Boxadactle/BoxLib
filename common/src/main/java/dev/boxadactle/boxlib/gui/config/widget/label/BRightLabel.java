package dev.boxadactle.boxlib.gui.config.widget.label;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * The BLeftLabel class represents a left-aligned label widget in a graphical user interface.
 * It extends the BLabel class and provides a method to render the label on the screen.
 */
public class BLeftLabel extends BLabel {
    /**
     * Constructs a new BLeftLabel with the specified message.
     *
     * @param message the text to be displayed on the label
     */
    public BLeftLabel(Component message) {
        super(message);
    }

    /**
     * Renders the label on the screen.
     *
     * @param guiGraphics the graphics object used for rendering
     * @param mouseX      the x-coordinate of the mouse cursor
     * @param mouseY      the y-coordinate of the mouse cursor
     * @param delta       the time since the last frame update
     */
    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        RenderUtils.drawText(guiGraphics, message, this.getX() + this.getWidth() - GuiUtils.getTextRenderer().width(message), this.getY() + 5);
    }
}
