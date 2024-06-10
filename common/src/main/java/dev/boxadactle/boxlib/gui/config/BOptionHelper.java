package dev.boxadactle.boxlib.gui.config;

import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Consumer;

/**
 * The BOptionHelper interface provides utility methods for creating buttons in GUI screens.
 */
public interface BOptionHelper {

    /**
     * Creates a cancel button with the specified position and parent screen.
     *
     * @param startX The x-coordinate of the button's top-left corner.
     * @param startY The y-coordinate of the button's top-left corner.
     * @param parent The parent screen to return to when the button is clicked.
     * @return The cancel button.
     */
    default Button createCancelButton(int startX, int startY, Screen parent) {
        return createCancelButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a cancel button with the specified position and button consumer.
     *
     * @param startX         The x-coordinate of the button's top-left corner.
     * @param startY         The y-coordinate of the button's top-left corner.
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The cancel button.
     */
    default Button createCancelButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.CANCEL, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    /**
     * Creates a done button with the specified position and parent screen.
     *
     * @param startX The x-coordinate of the button's top-left corner.
     * @param startY The y-coordinate of the button's top-left corner.
     * @param parent The parent screen to return to when the button is clicked.
     * @return The done button.
     */
    default Button createDoneButton(int startX, int startY, Screen parent) {
        return createDoneButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a done button with the specified position and button consumer.
     *
     * @param startX         The x-coordinate of the button's top-left corner.
     * @param startY         The y-coordinate of the button's top-left corner.
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The cancel button.
     */
    default Button createDoneButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.DONE, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    /**
     * Creates a back button with the specified position and parent screen.
     *
     * @param startX The x-coordinate of the button's top-left corner.
     * @param startY The y-coordinate of the button's top-left corner.
     * @param parent The parent screen to return to when the button is clicked.
     * @return The back button.
     */
    default Button createBackButton(int startX, int startY, Screen parent) {
        return new Button.Builder(GuiUtils.BACK, b -> ClientUtils.setScreen(parent))
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    /**
     * Creates a save button with the specified position and save consumer.
     *
     * @param startX       The x-coordinate of the button's top-left corner.
     * @param startY       The y-coordinate of the button's top-left corner.
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The save button.
     */
    default Button createSaveButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    /**
     * Creates a half-sized cancel button with the specified position and parent screen.
     *
     * @param startX The x-coordinate of the button's top-left corner.
     * @param startY The y-coordinate of the button's top-left corner.
     * @param parent The parent screen to return to when the button is clicked.
     * @return The half-sized cancel button.
     */
    default Button createHalfCancelButton(int startX, int startY, Screen parent) {
        return createHalfCancelButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a half-sized cancel button with the specified position and button consumer.
     *
     * @param startX         The x-coordinate of the button's top-left corner.
     * @param startY         The y-coordinate of the button's top-left corner.
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The half-sized cancel button.
     */
    default Button createHalfCancelButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.CANCEL, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    /**
     * Creates a half-sized done button with the specified position and parent screen.
     *
     * @param startX The x-coordinate of the button's top-left corner.
     * @param startY The y-coordinate of the button's top-left corner.
     * @param parent The parent screen to return to when the button is clicked.
     * @return The half-sized done button.
     */
    default Button createHalfDoneButton(int startX, int startY, Screen parent) {
        return createHalfDoneButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a half-sized done button with the specified position and button consumer.
     *
     * @param startX         The x-coordinate of the button's top-left corner.
     * @param startY         The y-coordinate of the button's top-left corner.
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The half-sized done button.
     */
    default Button createHalfDoneButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.DONE, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    /**
     * Creates a half-sized save button with the specified position and save consumer.
     *
     * @param startX       The x-coordinate of the button's top-left corner.
     * @param startY       The y-coordinate of the button's top-left corner.
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The half-sized save button.
     */
    default Button createHalfSaveButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .bounds(startX + getButtonWidth(ButtonType.SMALL) + getPadding(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    /**
     * Creates an ok button with the specified position and save consumer.
     *
     * @param startX       The x-coordinate of the button's top-left corner.
     * @param startY       The y-coordinate of the button's top-left corner.
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The ok button.
     */
    default Button createOkButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.OK, saveConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    /**
     * Creates a half-sized ok button with the specified position and save consumer.
     *
     * @param startX       The x-coordinate of the button's top-left corner.
     * @param startY       The y-coordinate of the button's top-left corner.
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The half-sized ok button.
     */
    default Button createHalfOkButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.OK, saveConsumer::accept)
                .bounds(startX + getButtonWidth(ButtonType.SMALL) + getPadding(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    /**
     * Creates an array of save and cancel buttons with the specified position, parent screen, and save consumer.
     *
     * @param startX       The x-coordinate of the buttons' top-left corner.
     * @param startY       The y-coordinate of the buttons' top-left corner.
     * @param parent       The parent screen to return to when the cancel button is clicked.
     * @param saveConsumer The consumer function to be called when the save button is clicked.
     * @return The array of save and cancel buttons.
     * @deprecated This method is deprecated and will be removed in a future release.
     */
    @Deprecated
    default Button[] createSaveAndCancelButton(int startX, int startY, Screen parent, Consumer<Button> saveConsumer) {
        return new Button[]{
                new Button.Builder(GuiUtils.CANCEL, b -> ClientUtils.setScreen(parent))
                        .bounds(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                        .build(),
                new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                        .bounds(startX + getButtonWidth(ButtonType.SMALL) + getButtonHeight(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                        .build()
        };
    }

    /**
     * Returns the height of the buttons.
     *
     * @return The button height.
     */
    default int getButtonHeight() {
        return BOptionHelper.buttonHeight();
    }

    /**
     * Returns the width of the buttons based on the specified type.
     *
     * @param type The type of the button.
     * @return The button width.
     * @throws IllegalStateException if the button type is not recognized.
     */
    default int getButtonWidth(ButtonType type) throws IllegalStateException {
        return BOptionHelper.buttonWidth(type);
    }

    /**
     * Returns the padding between buttons.
     *
     * @return The button padding.
     */
    default int getPadding() {
        return BOptionHelper.padding();
    }

    /**
     * Returns the default height of the buttons.
     *
     * @return The default button height.
     */
    static int buttonHeight() {
        return 20;
    }

    /**
     * Returns the width of the buttons based on the specified type.
     *
     * @param type The type of the button.
     * @return The button width.
     * @throws IllegalStateException if the button type is not recognized.
     */
    static int buttonWidth(ButtonType type) throws IllegalStateException {
        switch (type) {
            case NORMAL:
                return 250;
            case SMALL:
                return 250 / 2 - 2;
            case TINY:
                return 75;
            default:
                throw new IllegalStateException("Could not find button type" + type.name());
        }
    }

    /**
     * Returns the default padding between buttons.
     *
     * @return The default button padding.
     */
    static int padding() {
        return 2;
    }

    /**
     * Represents the type of a button.
     */
    enum ButtonType {
        NORMAL,
        SMALL,
        TINY
    }

}
