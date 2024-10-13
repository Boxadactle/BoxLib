package dev.boxadactle.boxlib.prompt.gui;

import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
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
        return inputBox.getValue();
    }

    @Override
    protected boolean allowContinue() {
        return inputBox != null && !inputBox.getValue().isBlank();
    }

    @Override
    protected void init() {
        super.init();

        inputBox = addRenderableWidget(new EditBox(
                font,
                this.width / 2 - 150,
                this.height / 2 - 10,
                300,
                20,
                Component.literal("Input box")
        ));
        inputBox.setMaxLength(100);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);

        RenderUtils.drawTextCentered(guiGraphics, message, this.width / 2, this.height / 2 - 30);
    }
}
