package dev.boxadactle.boxlib.gui.config.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.config.BOptionButton;
import net.minecraft.network.chat.Component;

/**
 * Represents a spacing entry in a GUI widget.
 * This class extends the BOptionButton class and provides functionality for rendering, handling click events, and changing the value of the entry.
 */
public class BSpacingEntry extends BOptionButton<Object> {

    /**
     * Constructs a new BSpacingEntry instance.
     */
    public BSpacingEntry() {
        super(Component.literal(""), null, a -> {});
    }

    /**
     * Renders the spacing entry on the screen.
     *
     * @param p_93657_ The GuiGraphics object used for rendering.
     * @param mouseX   The x-coordinate of the mouse cursor.
     * @param mouseY   The y-coordinate of the mouse cursor.
     * @param delta    The time since the last frame update.
     */
    @Override
    public void renderWidget(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
    }

    /**
     * Handles the click event on the spacing entry.
     *
     * @param mouseX The x-coordinate of the mouse cursor.
     * @param mouseY The y-coordinate of the mouse cursor.
     */
    @Override
    public void onClick(double mouseX, double mouseY) {
        // Implementation details
    }

    /**
     * Changes the value of the spacing entry.
     *
     * @param input The new value for the spacing entry.
     * @return The updated value of the spacing entry.
     */
    @Override
    protected Object changeValue(Object input) {
        // Implementation details
        return null;
    }
}
