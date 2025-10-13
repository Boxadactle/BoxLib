package dev.boxadactle.boxlib.gui.config;

import com.google.common.collect.ImmutableList;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Represents a list of configuration entries in a GUI screen.
 * Extends the ContainerObjectSelectionList class.
 */
public class BConfigList extends ContainerObjectSelectionList<BConfigList.ConfigEntry> implements LayoutElement {

    BOptionScreen screen;

    /**
     * Constructs a BConfigList with the specified Minecraft instance and BOptionScreen.
     *
     * @param minecraft The Minecraft instance.
     * @param screen The BOptionScreen that this list belongs to.
     */
    public BConfigList(Minecraft minecraft, BOptionScreen screen) {
        super(
                minecraft,
                screen.width,
                screen.layout.getContentHeight(),
                screen.layout.getHeaderHeight(),
                screen.getRowHeight()
        );
        this.screen = screen;
    }

    @Override
    public int getRowWidth() {
        return screen.getRowWidth();
    }

    @Override
    protected int scrollBarX() {
        return screen.getScrollbarX();
    }

    @Override
    public int addEntry(ConfigEntry entry) {
        return super.addEntry(entry);
    }

    /**
     * Checks if any of the entries in the list are invalid.
     * @return true if any of the entries are invalid, false otherwise.
     */
    public boolean hasInvalidEntry() {
        AtomicBoolean a = new AtomicBoolean(false);

        children().forEach(configWidgetEntry -> {
            if (configWidgetEntry.isInvalid()) a.set(true);
        });

        return a.get();
    }

    /**
     * Represents a single entry in the BOptionScreen.
     * This class extends the ConfigEntry class.
     */
    public static class SingleEntry extends ConfigEntry {

        BOptionEntry<?> widget;

        /**
         * Constructs a SingleEntry object with the specified BOptionEntry widget.
         * @param widget The BOptionEntry widget associated with this entry.
         */
        public SingleEntry(BOptionEntry<?> widget) {
            this.widget = widget;
        }

        @Override
        public void renderContent(GuiGraphics guiGraphics, int i, int j, boolean bl, float f) {
            AbstractWidget w = (AbstractWidget)widget;

            w.setX(getX());
            w.setY(getY());
            w.setWidth(getWidth());

            w.render(guiGraphics, i, j, f);
        }

        /**
         * Returns a list of widgets associated with this entry.
         * @return The list of widgets.
         */
        @Override
        public List<? extends AbstractWidget> getWidgets() {
            return ImmutableList.of((AbstractWidget) widget);
        }

        /**
         * Checks if the entry is invalid.
         * @return true if the entry is invalid, false otherwise.
         */
        @Override
        public boolean isInvalid() {
            return widget.isInvalid();
        }

    }

    /**
     * Represents a double entry in a configuration screen.
     * This class extends the ConfigEntry class and provides functionality for managing two BOptionEntry widgets.
     */
    public static class DoubleEntry extends ConfigEntry {
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

        @Override
        public void renderContent(GuiGraphics guiGraphics, int i, int j, boolean bl, float f) {
            AbstractWidget w1 = (AbstractWidget) widget1;
            AbstractWidget w2 = (AbstractWidget) widget2;

            int p1 = BOptionHelper.padding() / 2;
            int p2 = BOptionHelper.padding() / 2;

            w1.setX(getX());
            w1.setY(getY());
            w1.setWidth(getWidth() / 2 - p1);

            w2.setX(getX() + getWidth() / 2 + p2);
            w2.setY(getY());
            w2.setWidth(getWidth() / 2 - p2);

            w1.render(guiGraphics, i, j, f);
            w2.render(guiGraphics, i, j, f);
        }
    }

    /**
     * Represents a configuration entry in the BOptionScreen.
     * This class is an abstract subclass of ContainerObjectSelectionList.Entry&lt;ConfigEntry&gt;.
     * It provides methods for retrieving the list of widgets associated with the entry and checking if the entry is invalid.
     */
    public abstract static class ConfigEntry extends ContainerObjectSelectionList.Entry<ConfigEntry> {

        /**
         * Returns a list of narratable entries associated with this configuration entry.
         * @return The list of narratable entries.
         */
        @Override
        public List<? extends NarratableEntry> narratables() {
            return getWidgets();
        }

        /**
         * Returns a list of child GUI event listeners associated with this configuration entry.
         * @return The list of child GUI event listeners.
         */
        @Override
        public List<? extends GuiEventListener> children() {
            return getWidgets();
        }

        /**
         * Returns a list of abstract widgets associated with this configuration entry.
         * @return The list of abstract widgets.
         */
        public abstract List<? extends AbstractWidget> getWidgets();

        /**
         * Checks if this configuration entry is invalid.
         * @return true if the entry is invalid, false otherwise.
         */
        public abstract boolean isInvalid();

    }

}