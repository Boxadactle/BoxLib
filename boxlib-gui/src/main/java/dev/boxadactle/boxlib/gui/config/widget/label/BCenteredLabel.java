package dev.boxadactle.boxlib.gui.config.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

/**
 * A centered label widget that extends BLabel.
 * This widget displays a text message centered horizontally.
 */
public class BCenteredLabel extends BLabel {

    /**
     * Constructs a new BCenteredLabel with the specified message.
     * 
     * @param message the text message to display
     */
    public BCenteredLabel(Component message) {
        super(message);
    }

    /**
     * Renders the centered label widget.
     * 
     * @param p_93657_ the GuiGraphics instance
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param delta the time since the last tick
     */
    @Override
    public void renderButton(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        RenderUtils.drawTextCentered(p_93657_, message, this.getX() + this.width / 2, this.getY() + 5);
    }
}
