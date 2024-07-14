package dev.boxadactle.boxlib.gui.config.widget;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.function.Consumer8;
import dev.boxadactle.boxlib.gui.config.BOptionButton;
import net.minecraft.network.chat.Component;

/**
 * A custom rendering entry for a GUI widget.
 */
public class BCustomEntry extends BOptionButton<Object> {

    protected Consumer8<PoseStack, Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    /**
     * Constructs a BCustomRenderingEntry with the specified rendering function.
     *
     * @param function the rendering function to be called when rendering the entry
     */
    public BCustomEntry(Consumer8<PoseStack, Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super(Component.literal(""), null, null);

        this.function = function;
    }

    /**
     * Renders the entry using the specified graphics context, mouse coordinates, and delta value.
     *
     * @param p_93657_ the graphics context
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param delta the delta value
     */
    @Override
    public void renderButton(PoseStack p_93657_, int mouseX, int mouseY, float delta) {
        function.accept(p_93657_, this.x, this.y, this.width, this.height, mouseX, mouseY, delta);
    }

    /**
     * Handles the click event at the specified mouse coordinates.
     *
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     */
    @Override
    public void onClick(double mouseX, double mouseY) {
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
