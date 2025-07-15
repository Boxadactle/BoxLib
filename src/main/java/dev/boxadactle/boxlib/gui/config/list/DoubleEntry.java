package dev.boxadactle.boxlib.gui.config.list;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.config.BOptionEntry;
import dev.boxadactle.boxlib.gui.config.BOptionHelper;
import net.minecraft.client.gui.components.AbstractWidget;

import java.util.List;

/**
 * Represents a double entry in a configuration screen.
 * This class extends the ConfigEntry class and provides functionality for managing two BOptionEntry widgets.
 */
public class DoubleEntry extends BConfigList.ConfigEntry {
    BOptionEntry<?> widget1;
    BOptionEntry<?> widget2;

    /**
     * Constructs a new DoubleEntry with the specified BOptionEntry widgets.
     *
     * @param widget1 The first BOptionEntry widget.
     * @param widget2 The second BOptionEntry widget.
     */
    public DoubleEntry(BOptionEntry<?> widget1, BOptionEntry<?> widget2) {
        this.widget1 = widget1;
        this.widget2 = widget2;
    }

    /**
     * Returns a list of the BOptionEntry widgets contained in this DoubleEntry.
     *
     * @return A list of the BOptionEntry widgets.
     */
    @Override
    public List<? extends AbstractWidget> getWidgets() {
        return ImmutableList.of((AbstractWidget) widget1, (AbstractWidget) widget2);
    }

    /**
     * Checks if either of the BOptionEntry widgets in this DoubleEntry is invalid.
     *
     * @return true if either of the widgets is invalid, false otherwise.
     */
    @Override
    public boolean isInvalid() {
        return widget1.isInvalid() || widget2.isInvalid();
    }

    /**
     * Renders the BOptionEntry widgets in this DoubleEntry.
     *
     * @param p_93523_     The GuiGraphics object used for rendering.
     * @param index        The index of the entry.
     * @param y            The y-coordinate of the entry.
     * @param x            The x-coordinate of the entry.
     * @param entryWidth   The width of the entry.
     * @param entryHeight  The height of the entry.
     * @param mouseX       The x-coordinate of the mouse.
     * @param mouseY       The y-coordinate of the mouse.
     * @param hovered      Whether the entry is being hovered over.
     * @param tickDelta    The tick delta value.
     */
    @Override
    public void render(PoseStack p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
        AbstractWidget w1 = (AbstractWidget) widget1;
        AbstractWidget w2 = (AbstractWidget) widget2;

        int p1 = BOptionHelper.padding() / 2;
        int p2 = BOptionHelper.padding() / 2;

        w1.x = x;
        w1.y = y;
        w1.setWidth(entryWidth / 2 - p1);

        w2.x = x + entryWidth / 2 + p2;
        w2.y = y;
        w2.setWidth(entryWidth / 2 - p2);

        w1.render(p_93523_, mouseX, mouseY, tickDelta);
        w2.render(p_93523_, mouseX, mouseY, tickDelta);
    }
}
