package dev.boxadactle.boxlib.gui.config.list;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.gui.config.BOptionEntry;
import net.minecraft.client.gui.components.AbstractWidget;

import java.util.List;

/**
 * Represents a single entry in the BOptionScreen.
 * This class extends the ConfigEntry class.
 */
public class SingleEntry extends BConfigList.ConfigEntry {

    BOptionEntry<?> widget;

    /**
     * Constructs a SingleEntry object with the specified BOptionEntry widget.
     *
     * @param widget The BOptionEntry widget associated with this entry.
     */
    public SingleEntry(BOptionEntry<?> widget) {
        this.widget = widget;
    }

    /**
     * Renders the entry on the screen.
     *
     * @param p_93523_    The GuiGraphics object used for rendering.
     * @param index       The index of the entry.
     * @param y           The y-coordinate of the entry.
     * @param x           The x-coordinate of the entry.
     * @param entryWidth  The width of the entry.
     * @param entryHeight The height of the entry.
     * @param mouseX      The x-coordinate of the mouse.
     * @param mouseY      The y-coordinate of the mouse.
     * @param hovered     Whether the entry is being hovered over.
     * @param tickDelta   The tick delta value.
     */
    @Override
    public void render(PoseStack p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
        AbstractWidget w = (AbstractWidget) widget;

        w.x = x;
        w.y = y;
        w.setWidth(entryWidth);

        w.render(p_93523_, mouseX, mouseY, tickDelta);
    }

    /**
     * Returns a list of widgets associated with this entry.
     *
     * @return The list of widgets.
     */
    @Override
    public List<? extends AbstractWidget> getWidgets() {
        return ImmutableList.of((AbstractWidget) widget);
    }

    /**
     * Checks if the entry is invalid.
     *
     * @return true if the entry is invalid, false otherwise.
     */
    @Override
    public boolean isInvalid() {
        return widget.isInvalid();
    }

}
