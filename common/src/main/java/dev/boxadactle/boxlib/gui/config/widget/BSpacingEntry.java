package dev.boxadactle.boxlib.gui.config.widget;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import net.minecraft.client.gui.GuiGraphics;
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

    @Override
    protected void renderContents(GuiGraphics guiGraphics, int i, int i1, float v) {
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
