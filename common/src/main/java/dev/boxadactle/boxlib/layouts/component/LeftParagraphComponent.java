package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * Represents a paragraph component that aligns its content to the left side.
 * Extends the {@link ParagraphComponent} class.
 */
public class LeftParagraphComponent extends ParagraphComponent {
    /**
     * Constructs a new LeftParagraphComponent with the specified text padding and components.
     *
     * @param textPadding the padding between the text and the component's boundaries
     * @param components  the components to be rendered within the paragraph
     */
    public LeftParagraphComponent(int textPadding, Component... components) {
        super(textPadding, components);
    }

    /**
     * Renders the LeftParagraphComponent on the screen.
     *
     * @param graphics the graphics object used for rendering
     * @param x        the x-coordinate of the component's position
     * @param y        the y-coordinate of the component's position
     */
    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;
        int thisWidth = getWidth();

        for (Component component : this.component) {
            int width = GuiUtils.getTextSize(component);
            graphics.drawString(GuiUtils.getTextRenderer(), component, x + thisWidth - width, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
