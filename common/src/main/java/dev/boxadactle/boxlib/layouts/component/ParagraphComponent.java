package dev.boxadactle.boxlib.layouts.component;

import dev.boxadactle.boxlib.layouts.LayoutComponent;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParagraphComponent extends LayoutComponent<List<Component>> {

    int textPadding;

    public ParagraphComponent(int textPadding, Component ...components) {
        super(new ArrayList<>());

        this.textPadding = textPadding;

        this.component.addAll(Arrays.asList(components));
    }

    public void add(Component component) {
        this.component.add(component);
    }

    public void remove(Component component) {
        this.component.remove(component);
    }

    @Override
    public int getWidth() {
        return GuiUtils.getLongestLength(component.toArray(new Component[]{}));
    }

    @Override
    public int getHeight() {
        return component.size() * (GuiUtils.getTextHeight() + textPadding * 2) - textPadding * 2;
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y) {
        int currentY = y;

        for (Component component : this.component) {
            graphics.drawString(GuiUtils.getTextRenderer(), component, x, currentY, GuiUtils.WHITE);

            currentY += GuiUtils.getTextHeight() + textPadding * 2;
        }
    }
}
