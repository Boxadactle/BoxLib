package dev.boxadactle.boxlib.gui.config.widget;

import dev.boxadactle.boxlib.function.Consumer7;
import dev.boxadactle.boxlib.gui.config.BOptionButton;

/**
 * A custom rendering entry for a GUI widget.
 */
public class BCustomEntry extends BOptionButton<Object> {

    protected Consumer7<Integer, Integer, Integer, Integer, Integer, Integer, Float> function;

    /**
     * Constructs a BCustomRenderingEntry with the specified rendering function.
     *
     * @param function the rendering function to be called when rendering the entry
     */
    public BCustomEntry(Consumer7<Integer, Integer, Integer, Integer, Integer, Integer, Float> function) {
        super("", null, null);

        this.function = function;
    }

    /**
     * Renders the entry using the specified graphics context, mouse coordinates, and delta value.
     *
     * @param mouseX the x-coordinate of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param delta the delta value
     */
    @Override
    public void renderButton(int mouseX, int mouseY, float delta) {
        function.accept(this.x, this.y, this.width, this.height, mouseX, mouseY, delta);
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
