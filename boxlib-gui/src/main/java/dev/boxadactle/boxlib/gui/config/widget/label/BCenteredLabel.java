package dev.boxadactle.boxlib.gui.config.widget.label;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

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
    public BCenteredLabel(String message) {
        super(message);
    }

    /**
     * Renders the centered label widget.
     *
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param delta the time since the last tick
     */
    @Override
    public void renderButton(int mouseX, int mouseY, float delta) {
        RenderUtils.drawTextCentered(new TextComponent(message), this.x + this.width / 2, this.y + 5);
    }
}
