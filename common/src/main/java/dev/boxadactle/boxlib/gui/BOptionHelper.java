package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Consumer;

public interface BOptionHelper {

    default Button createCancelButton(int startX, int startY, Screen parent) {
        return createCancelButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    default Button createCancelButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.CANCEL, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default Button createBackButton(int startX, int startY, Screen parent) {
        return new Button.Builder(GuiUtils.BACK, b -> ClientUtils.setScreen(parent))
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default Button createSaveButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default Button createHalfCancelButton(int startX, int startY, Screen parent) {
        return createHalfCancelButton(startX, startY, b -> ClientUtils.setScreen(parent));
    }

    default Button createHalfCancelButton(int startX, int startY, Consumer<Button> ButtonConsumer) {
        return new Button.Builder(GuiUtils.CANCEL, ButtonConsumer::accept)
                .bounds(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    default Button createHalfSaveButton(int startX, int startY, Consumer<Button> saveConsumer) {
        return new Button.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .bounds(startX + getButtonWidth(ButtonType.SMALL) + getPadding(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

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

    default int getButtonHeight() {
        return BOptionHelper.buttonHeight();
    }

    default int getButtonWidth(ButtonType type) throws IllegalStateException {
        return BOptionHelper.buttonWidth(type);
    }

    default int getPadding() {
        return BOptionHelper.padding();
    }

    static int buttonHeight() {
        return 20;
    }

    static int buttonWidth(ButtonType type) throws IllegalStateException {
        switch (type) {
            case NORMAL: return 250;
            case SMALL: return 250 / 2 - 2;
            case TINY: return 75;
            default: throw new IllegalStateException("Could not find button type" + type.name());
        }
    }

    static int padding() {
        return 2;
    }
    
    enum ButtonType {
        NORMAL,
        SMALL,
        TINY
    }

}
