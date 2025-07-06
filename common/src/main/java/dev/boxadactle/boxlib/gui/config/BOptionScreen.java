package dev.boxadactle.boxlib.gui.config;

import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

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
 * <p>
 *     // Add additional methods and configuration options as needed
 * <p>
 * }
 * ```
 */
public abstract class BOptionScreen extends OptionsSubScreen implements BOptionHelper {

    protected BConfigList configList;

    protected Button saveButton;

    public BOptionScreen(Screen parent, Component name) {
        super(parent, ClientUtils.getOptions(), name);
    }

    @Override
    protected void addContents() {
        configList = new BConfigList(ClientUtils.getClient(), this);
        if (shouldRenderScrollingWidget()) layout.addToContents(configList);

        addOptions();
    }

    @Override
    protected void addFooter() {
        LinearLayout linearLayout = layout.addToFooter(LinearLayout.horizontal().spacing(BOptionHelper.padding()));

        initFooter(linearLayout);
    }

    @Override
    protected void repositionElements() {
        layout.setHeaderHeight(getHeaderHeight());
        layout.setFooterHeight(getFooterHeight());

        layout.arrangeElements();
        configList.updateSize(width, layout);
    }

    @Override
    public void tick() {
        super.tick();

        if (saveButton != null) {
            boolean a = !configList.hasInvalidEntry();
            if (saveButton.active != a) saveButton.active = a;
        }
    }

    protected abstract void initFooter(LinearLayout layout);

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
    protected int getScrollbarX() {
        return width / 2 + 124;
    }

    /**
     * Override this method to change the height of the header
     * @return The height of the header
     */
    protected int getHeaderHeight() {
        return 30;
    }

    /**
     * Override this method to change the height of the footer
     * @return The height of the footer
     */
    protected int getFooterHeight() {
        return 30;
    }

    @Deprecated
    protected BOptionEntry<?> addConfigOption(BOptionEntry<?> entry) {
        configList.addEntry(new BConfigList.SingleEntry(entry));

        return entry;
    }

    /**
     * Use this method to add a new line with 1 config option
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends BOptionEntry<?>> T addConfigLine(T entry) {
        configList.addEntry(new BConfigList.SingleEntry(entry));

        return entry;
    }

    /**
     * Use this method to add new line with 2 config options
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends BOptionEntry<?>> BOptionEntry<?>[] addConfigLine(T entry, T entry2) {
        configList.addEntry(new BConfigList.DoubleEntry(entry, entry2));

        return new BOptionEntry[]{entry, entry2};
    }
    
    /**
     * Use this method to add a new line with your own config entry renderer
     * @param entry A config entry renderer (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BConfigList.ConfigEntry}
     * @return Returns the passed-in entry
     */
    protected <T extends BConfigList.ConfigEntry> T addConfigLine(T entry) {
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
        this.addRenderableWidget(new Button.Builder(label, b -> {
            ClientUtils.openLinkConfirmScreen(link, this);
        }).bounds(3, 3, BOptionHelper.buttonWidth(ButtonType.TINY), BOptionHelper.buttonHeight() - 3).build());
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
        return saveButton;
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

}
