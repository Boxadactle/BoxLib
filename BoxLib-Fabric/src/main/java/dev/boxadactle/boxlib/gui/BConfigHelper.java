package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

import java.util.function.Consumer;

public interface BConfigHelper {

    default ButtonWidget createCancelButton(int startX, int startY, Screen parent) {
        return new ButtonWidget.Builder(GuiUtils.CANCEL, b -> ClientUtils.setScreen(parent))
                .dimensions(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default ButtonWidget createBackButton(int startX, int startY, Screen parent) {
        return new ButtonWidget.Builder(GuiUtils.BACK, b -> ClientUtils.setScreen(parent))
                .dimensions(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default ButtonWidget createSaveButton(int startX, int startY, Consumer<ButtonWidget> saveConsumer) {
        return new ButtonWidget.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .dimensions(startX, startY, getButtonWidth(ButtonType.NORMAL), getButtonHeight())
                .build();
    }

    default ButtonWidget createHalfCancelButton(int startX, int startY, Screen parent) {
        return new ButtonWidget.Builder(GuiUtils.CANCEL, b -> ClientUtils.setScreen(parent))
                .dimensions(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    default ButtonWidget createHalfSaveButton(int startX, int startY, Consumer<ButtonWidget> saveConsumer) {
        return new ButtonWidget.Builder(GuiUtils.SAVE, saveConsumer::accept)
                .dimensions(startX + getButtonWidth(ButtonType.SMALL) + getPadding(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                .build();
    }

    @Deprecated
    default ButtonWidget[] createSaveAndCancelButton(int startX, int startY, Screen parent, Consumer<ButtonWidget> saveConsumer) {
        return new ButtonWidget[]{
                new ButtonWidget.Builder(GuiUtils.CANCEL, b -> ClientUtils.setScreen(parent))
                        .dimensions(startX, startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                        .build(),
                new ButtonWidget.Builder(GuiUtils.SAVE, saveConsumer::accept)
                        .dimensions(startX + getButtonWidth(ButtonType.SMALL) + getButtonHeight(), startY, getButtonWidth(ButtonType.SMALL), getButtonHeight())
                        .build()
        };
    }

    default int getButtonHeight() {
        return BConfigHelper.buttonHeight();
    }

    default int getButtonWidth(ButtonType type) throws IllegalStateException {
        return BConfigHelper.buttonWidth(type);
    }

    default int getPadding() {
        return BConfigHelper.padding();
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
