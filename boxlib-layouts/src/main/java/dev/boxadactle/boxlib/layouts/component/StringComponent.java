package dev.boxadactle.boxlib.layouts.component;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.network.chat.Component;

/**
 * Represents a layout component that displays a string.
 */
public class StringComponent extends LayoutComponent<String> {

    /**
     * Constructs a new StringComponent with the specified string.
     *
     * @param component the string to be displayed by this component
     */
    public StringComponent(String component) {
        super(component);
    }

    /**
     * Returns the width of this component.
     *
     * @return the width of this component
     */
    @Override
    public int getWidth() {
        return GuiUtils.getTextSize(Component.literal(this.component));
    }

    /**
     * Returns the height of this component.
     *
     * @return the height of this component
     */
    @Override
    public int getHeight() {
        return GuiUtils.getTextHeight();
    }

    /**
     * Renders this component on the specified graphics context at the specified position.
     *
     * @param graphics the graphics context to render on
     * @param x        the x-coordinate of the top-left corner of this component
     * @param y        the y-coordinate of the top-left corner of this component
     */
    @Override
    public void render(PoseStack graphics, int x, int y) {
        RenderUtils.drawText(graphics, Component.literal(this.component), x, y);
    }
}
