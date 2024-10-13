package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * Represents a paragraph component that is centered horizontally.
 * Extends the {@link ParagraphComponent} class.
 */
public class CenteredParagraphComponent extends ParagraphComponent {
    /**
     * Constructs a new CenteredParagraphComponent with the specified text padding and components.
     *
     * @param textPadding the padding around the text
     * @param components  the components to be rendered in the paragraph
     */
    public CenteredParagraphComponent(int textPadding, Component... components) {
        super(textPadding, components);
    }

    /**
     * Renders the centered paragraph component on the screen.
     *
     * @param graphics the graphics object used for rendering
     * @param x        the x-coordinate of the top-left corner of the component
     * @param y        the y-coordinate of the top-left corner of the component
     */
    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;
        int calculatedWidth = this.getWidth();

        for (Component component : this.component) {
            graphics.drawCenteredString(GuiUtils.getTextRenderer(), component, x + calculatedWidth / 2, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
