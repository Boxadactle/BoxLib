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
     * @param parent The parent screen to return to when the button is clicked.
     * @return The cancel button.
     */
    default Button createCancelButton(Screen parent) {
        return createCancelButton(b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a cancel button with the specified position and button consumer.
     *
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The cancel button.
     */
    default Button createCancelButton(Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.CANCEL, ButtonConsumer::accept)
                .build();
    }

    /**
     * Creates a done button with the specified position and parent screen.
     *
     * @param parent The parent screen to return to when the button is clicked.
     * @return The done button.
     */
    default Button createDoneButton(Screen parent) {
        return createDoneButton(b -> ClientUtils.setScreen(parent));
    }

    /**
     * Creates a done button with the specified position and button consumer.
     *
     * @param ButtonConsumer The consumer function to be called when the button is clicked.
     * @return The cancel button.
     */
    default Button createDoneButton(Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.DONE, ButtonConsumer::accept).build();
    }

    /**
     * Creates a back button with the specified position and parent screen.
     *
     * @param parent The parent screen to return to when the button is clicked.
     * @return The back button.
     */
    default Button createBackButton(Screen parent) {
        return new Button.Builder(GuiUtils.BACK, b -> ClientUtils.setScreen(parent))
                .build();
    }

    /**
     * Creates a save button with the specified position and save consumer.
     *
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The save button.
     */
    default Button createSaveButton(Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .build();
    }

    /**
     * Creates an ok button with the specified position and save consumer.
     *
     * @param saveConsumer The consumer function to be called when the button is clicked.
     * @return The ok button.
     */
    default Button createOkButton(Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.OK, saveConsumer::accept)
                .build();
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
