package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a paragraph component that displays a list of components in a vertical layout.
 */
public class ParagraphComponent extends LayoutComponent<List<Component>> {

    int textPadding;

    /**
     * @param textPadding the padding around the text in each component
     * @param components the components to be displayed in the paragraph
     */
    public ParagraphComponent(int textPadding, Component ...components) {
        super(new ArrayList<>());
        this.textPadding = textPadding;

        this.component.addAll(Arrays.asList(components));
    }
    /**
     * Adds a component to the paragraph.
     *
     * @param component the component to be added
     */
    public void add(Component component) {
        this.component.add(component);
    }

    /**
     * Removes a component from the paragraph.
     *
     * @param component the component to be removed
     */
    public void remove(Component component) {
        this.component.remove(component);
    }

    /**
     * Returns the width of the paragraph component.
     *
     * @return the width of the paragraph component
     */
    @Override
    public int getWidth() {
        return GuiUtils.getLongestLength(component.toArray(new Component[]{}));
    }

    /**
     * Returns the height of the paragraph component.
     *
     * @return the height of the paragraph component
     */
    @Override
    public int getHeight() {
        return component.size() * (GuiUtils.getTextHeight() + textPadding * 2) - textPadding * 2;
    }

    /**
     * Renders the paragraph component on the screen.
     *
     * @param graphics the graphics object used for rendering
     * @param x the x-coordinate of the top-left corner of the component
     * @param y the y-coordinate of the top-left corner of the component
     */
    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;

        for (Component component : this.component) {
            graphics.drawString(GuiUtils.getTextRenderer(), component, x, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
