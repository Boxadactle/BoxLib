package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * Represents a text component that can be rendered in a graphical user interface.
 * This component extends the LayoutComponent class.
 */
public class TextComponent extends LayoutComponent<Component> {

    /**
     * Constructs a new TextComponent with the specified component.
     *
     * @param component the component to be wrapped by this TextComponent
     */
    public TextComponent(Component component) {
        super(component);
    }

    /**
     * Returns the width of the text component.
     *
     * @return the width of the text component
     */
    @Override
    public int getWidth() {
        return GuiUtils.getTextSize(this.component);
    }

    /**
     * Returns the height of the text component.
     *
     * @return the height of the text component
     */
    @Override
    public int getHeight() {
        return GuiUtils.getTextHeight();
    }

    /**
     * Renders the text component on the specified graphics object at the given coordinates.
     *
     * @param graphics the graphics object to render on
     * @param x        the x-coordinate of the top-left corner of the component
     * @param y        the y-coordinate of the top-left corner of the component
     */
    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        RenderUtils.drawText(graphics, this.component, x, y);
    }
}
