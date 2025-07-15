package dev.boxadactle.boxlib.layouts.component;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
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
     * @param poseStack      the pose stack
     * @param x              the x-coordinate of the top-left corner of the component
     * @param y              the y-coordinate of the top-left corner of the component
     */
    @Override
    public void render(PoseStack poseStack, int x, int y) {
        int currentY = y;
        int calculatedWidth = this.getWidth();

        for (Component component : this.component) {
            RenderUtils.drawTextCentered(poseStack, component, x + calculatedWidth / 2, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
