package dev.boxadactle.boxlib.gui.config.widget;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.function.Consumer8;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * A custom rendering entry for a GUI widget.
 */
public class BCustomEntry extends BOptionButton<Object> {

    protected Consumer8<GuiGraphics, Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    /**
     * Constructs a BCustomRenderingEntry with the specified rendering function.
     *
     * @param function the rendering function to be called when rendering the entry
     */
    public BCustomEntry(Consumer8<GuiGraphics, Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super(Component.literal(""), null, null);

        this.function = function;
    }

    @Override
    protected void renderContents(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        function.accept(guiGraphics, this.getX(), this.getY(), this.width, this.height, mouseX, mouseY, delta);
    }

    /**
     * Changes the value of the entry.
     *
     * @param input the new value
     * @return the changed value
     */
    @Override
    protected Object changeValue(Object input) {
        return null;
    }

}
