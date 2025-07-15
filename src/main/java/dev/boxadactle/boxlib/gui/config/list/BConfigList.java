package dev.boxadactle.boxlib.gui.config.list;

import dev.boxadactle.boxlib.gui.config.BOptionScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Represents a list of configuration entries in a GUI screen.
 * Extends the ContainerObjectSelectionList class.
 */
public class BConfigList extends ContainerObjectSelectionList<BConfigList.ConfigEntry> {

    BOptionScreen screen;

    public BConfigList(Minecraft minecraft, BOptionScreen screen) {
        super(
                minecraft,
                screen.width,
                screen.height,
                screen.getScrollingWidgetStart(),
                screen.getScrollingWidgetEnd(),
                screen.getRowHeight()
        );

        this.screen = screen;
    }

    @Override
    public int getRowWidth() {
        return screen.getRowWidth();
    }

    @Override
    protected int getScrollbarPosition() {
        return screen.getScrollbarPosition();
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
     * Represents a configuration entry in the BOptionScreen.
     * This class is an abstract subclass of ContainerObjectSelectionList.Entry<ConfigEntry>.
     * It provides methods for retrieving the list of widgets associated with the entry and checking if the entry is invalid.
     */
    public static abstract class ConfigEntry extends ContainerObjectSelectionList.Entry<ConfigEntry> {

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