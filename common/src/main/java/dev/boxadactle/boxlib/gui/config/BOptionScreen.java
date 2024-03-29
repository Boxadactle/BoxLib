package dev.boxadactle.boxlib.gui.config;

import com.google.common.collect.ImmutableList;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
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
 * The BoxLib config class
 * Extend this class to make basic config screens
 * <p></p>
 * Config values can be accessed/saved with config classes.
 * You can use an external library such as Cloth Config, but BoxLib already handles config
 * @see dev.boxadactle.boxlib.config.BConfig
 * @see dev.boxadactle.boxlib.config.BConfigFile
 */
public abstract class BOptionScreen extends Screen implements BOptionHelper {

    protected Screen parent;

    protected BOptionList configList;

    protected Button saveButton;

    protected BOptionScreen(Screen parent) {
        super(Component.literal("Config Screen"));

        this.parent = parent;
    }

    @Override
    protected void init() {
        configList = new BOptionList(ClientUtils.getClient(), this);
        this.addWidget(configList);

        initConfigButtons();
        initFooter(this.width / 2 - BOptionHelper.padding() / 2 - BOptionHelper.buttonWidth(ButtonType.SMALL), this.height - getButtonHeight() - getPadding());
    }

    @Override
    public void onClose() {
        ClientUtils.getClient().setScreen(parent);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);

        if (shouldRenderScrollingWidget()) this.configList.render(guiGraphics, i, j, f);

        RenderUtils.drawTextCentered(guiGraphics, this.getName(), this.width / 2, 5);
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
     * Use this method to add a new line with 1 config option
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected BOptionEntry<?> addConfigLine(BOptionEntry<?> entry) {
        configList.addEntry(new BOptionList.SingleEntry(entry));

        return entry;
    }

    /**
     * Use this method to add new line with 2 config options
     * @param entry A config entry (either provided by BoxLib or created yourself)
     *              To create your own entry, extend the {@link BOptionEntry}
     * @return Returns the passed-in entry
     */
    protected BOptionEntry<?>[] addConfigLine(BOptionEntry<?> entry, BOptionEntry<?> entry2) {
        configList.addEntry(new BOptionList.DoubleEntry(entry, entry2));

        return new BOptionEntry[]{entry, entry2};
    }

    /**
     * Use this method to set the wiki of the said page
     * Don't run this method if you don't want a wiki button on the screem
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
        return addRenderableWidget(saveButton);
    }

    public interface Provider<T extends Screen> {

        T createScreen(Screen parent);

    }
}
