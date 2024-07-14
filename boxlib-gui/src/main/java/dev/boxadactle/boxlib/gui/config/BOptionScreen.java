package dev.boxadactle.boxlib.gui.config;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The BOptionScreen class represents a screen for configuring options.
 * It extends the Screen class and implements the BOptionHelper interface.
 * This class provides methods for adding and managing configuration options,
 * rendering the screen, and handling user input.
 * <p>
 * The BOptionScreen class is intended to be extended by specific configuration screens
 * for different mods or features. It provides a framework for creating a consistent
 * and user-friendly configuration experience.
 * <p>
 * To use the BOptionScreen class, create a subclass and implement the abstract methods
 * to define the screen's name, footer, and configuration buttons. Use the provided
 * methods to add configuration options to the screen. Override the shouldRenderScrollingWidget()
 * method to control whether the configuration widget should be rendered on the screen.
 * <p>
 * The BOptionScreen class also provides methods for setting a wiki button and a save button.
 * The wiki button opens a link to a wiki page when clicked, and the save button allows the user
 * to save their configuration settings.
 * <p>
 * Example usage:
 * ```
 * public class MyConfigScreen extends BOptionScreen {
 * <p>
 *     public MyConfigScreen(Screen parent) {
 *         super(parent);
 *     }
 *
 *     @Override
 *     protected Component getName() {
 *         return Component.text("My Config Screen");
 *     }
 *
 *     @Override
 *     protected void initFooter(int startX, int startY) {
 *         // Initialize footer buttons
 *     }
 *
 *     @Override
 *     protected void initConfigButtons() {
 *         // Initialize configuration buttons
 *     }
 *
 *     @Override
 *     protected boolean shouldRenderScrollingWidget() {
 *         return true;
 *     }
 * <p>
 *     // Add additional methods and configuration options as needed
 * <p>
 * }
 * ```
 */
public abstract class BOptionScreen extends Screen implements BOptionHelper {

    protected Screen parent;

    protected ConfigList configList;

    protected Button saveButton;

    public BOptionScreen(Screen parent) {
        super(Component.literal("Config Screen"));

        this.parent = parent;
    }

    @Override
    protected void init() {
        configList = new ConfigList(ClientUtils.getClient());
        this.addWidget(configList);

        initConfigButtons();
        initFooter(this.width / 2 - BOptionHelper.padding() / 2 - BOptionHelper.buttonWidth(ButtonType.SMALL), this.height - getButtonHeight() - getPadding());
    }

    @Override
    public void onClose() {
        ClientUtils.getClient().setScreen(parent);
    }

    @Override
    public void render(PoseStack stack, int i, int j, float f) {
        if (shouldRenderScrollingWidget()) this.configList.render(stack, i, j, f);

        super.render(stack, i, j, f);

        RenderUtils.drawTextCentered(stack, this.getName(), this.width / 2, 5);
    }

    @Override
    public void tick() {
        super.tick();

        if (saveButton != null) {
            boolean a = !configList.hasInvalidEntry();
            if (saveButton.active != a) saveButton.active = a;
        }
    }

    protected abstract Component getName();

    protected abstract void initFooter(int startX, int startY);
    protected abstract void initConfigButtons();

    /**
     * Override this method if you don't want the config
     * widget to render on the screen
     *
     * @return Controls whether the widget should render
     */
    protected boolean shouldRenderScrollingWidget() {
        return true;
    }

    /**
     * Override this method to change the width of each row
     * @return The width of each row
     */
    protected int getRowWidth() {
        return 220;
    }

    /**
     * Override this method to change the height of each row
     * @return The height of each row
     */
    protected int getRowHeight() {
        return BOptionHelper.buttonHeight() + BOptionHelper.padding() * 2;
    }

    /**
     * Override this method to change the x position of the scrollbar
     * @return The x position of the scrollbar
     */
    protected int getScrollbarPosition() {
        return width / 2 + 124;
    }

    /**
     * Override this method to change the start y value of the scrolling widget
     * @return The height of the buttons
     */
    protected int getScrollingWidgetStart() {
        return 20;
    }

    /**
     * Override this method to change the end y value of the scrolling widget
     * @return The height of the buttons
     */
    protected int getScrollingWidgetEnd() {
        return this.height - 30;
    }

    @Deprecated
    protected BOptionEntry<?> addConfigOption(BOptionEntry<?> entry) {
        configList.addEntry(new ConfigList.SingleEntry(entry));

        return entry;
    }

    /**
     * Use this method to add a new line with 1 config option
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends BOptionEntry<?>> T addConfigLine(T entry) {
        configList.addEntry(new ConfigList.SingleEntry(entry));

        return entry;
    }

    /**
     * Use this method to add new line with 2 config options
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends BOptionEntry<?>> BOptionEntry<?>[] addConfigLine(T entry, T entry2) {
        configList.addEntry(new ConfigList.DoubleEntry(entry, entry2));

        return new BOptionEntry[]{entry, entry2};
    }
    
    /**
     * Use this method to add a new line with your own config entry renderer
     * @param entry A config entry renderer (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionScreen.ConfigList.ConfigEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends ConfigList.ConfigEntry> T addConfigLine(T entry) {
        configList.addEntry(entry);

        return entry;
    }

    /**
     * Use this method to set the wiki link of the screen
     * Don't run this method if you don't want a wiki button on the screen
     * @param label Component that should be rendered as the button.
     * @param link The link to the wiki that will open when the button is clicked.
     */
    protected void setWiki(Component label, String link) {
        this.addRenderableWidget(new Button(3, 3, BOptionHelper.buttonWidth(ButtonType.TINY), BOptionHelper.buttonHeight() - 3, label, b -> {
            ClientUtils.openLinkConfirmScreen(link, this);
        }));
    }

    /**
     * Make sure to run this method if you have a save button
     * <p>
     * This method will allow the save button to toggle on/of
     * when the values passed in by the user are invalid/valid.
     * <p>
     * This will make sure that the values saved to the
     * config file are always valid, and the user cannot save unless all values are correct
     *
     * @param saveButton The save button that should be recognized by the config class.
     *                   You can use the methods from {@link BOptionHelper} to create the save button
     */
    protected Button setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
        return addRenderableWidget(saveButton);
    }

    /**
     * A functional interface for creating screens.
     *
     * @param <T> the type of the screen to be created
     */
    public interface Provider<T extends Screen> {

        /**
         * Creates a new screen with the given parent screen.
         *
         * @param parent the parent screen
         * @return the newly created screen
         */
        T createScreen(Screen parent);

    }

    /**
     * Represents a list of configuration entries in a GUI screen.
     * Extends the ContainerObjectSelectionList class.
     */
    public class ConfigList extends ContainerObjectSelectionList<ConfigList.ConfigEntry> {

        public ConfigList(Minecraft minecraft) {
            super(
                    minecraft,
                    BOptionScreen.this.width,
                    BOptionScreen.this.height,
                    BOptionScreen.this.getScrollingWidgetStart(),
                    BOptionScreen.this.getScrollingWidgetEnd(),
                    BOptionScreen.this.getRowHeight()
            );
        }

        @Override
        public int getRowWidth() {
            return BOptionScreen.this.getRowWidth();
        }

        @Override
        protected int getScrollbarPosition() {
            return BOptionScreen.this.getScrollbarPosition();
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

            /**
             * Renders the entry on the screen.
             * @param p_93523_ The GuiGraphics object used for rendering.
             * @param index The index of the entry.
             * @param y The y-coordinate of the entry.
             * @param x The x-coordinate of the entry.
             * @param entryWidth The width of the entry.
             * @param entryHeight The height of the entry.
             * @param mouseX The x-coordinate of the mouse.
             * @param mouseY The y-coordinate of the mouse.
             * @param hovered Whether the entry is being hovered over.
             * @param tickDelta The tick delta value.
             */
            @Override
            public void render(PoseStack p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
                AbstractWidget w = (AbstractWidget)widget;

                w.x = x;
                w.y = y;
                w.setWidth(entryWidth);

                w.render(p_93523_, mouseX, mouseY, tickDelta);
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

        /**
         * Represents a configuration entry in the BOptionScreen.
         * This class is an abstract subclass of ContainerObjectSelectionList.Entry<ConfigEntry>.
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

}
