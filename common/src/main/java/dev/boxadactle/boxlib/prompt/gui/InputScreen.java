package dev.boxadactle.boxlib.prompt.gui;

import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class InputScreen extends PromptScreen<String> {

    EditBox inputBox;

    Component message;

    public InputScreen(Screen parent, Component message) {
        super(parent);

        this.message = message;
    }

    @Override
    protected String getData() {
        return inputBox.getValue().isBlank() ? null : inputBox.getValue();
    }

    @Override
    protected boolean allowContinue() {
        return inputBox != null && !inputBox.getValue().isBlank();
    }

    @Override
    protected void init() {
        layout.addTitleHeader(message, GuiUtils.getTextRenderer());

        inputBox = layout.addToContents(new EditBox(
                font,
                this.width / 2 - 150,
                this.height / 2 - 10,
                300,
                20,
                Component.literal("Input box")
        ));
        inputBox.setMaxLength(100);

        super.init();
    }
}
