package dev.boxadactle.boxlib.prompt.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

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

        inputBox = addButton(new EditBox(
                font,
                this.width / 2 - 150,
                this.height / 2 - 10,
                300,
                20,
                "Input box"
        ));
        inputBox.setMaxLength(100);
    }

    @Override
    public void render(int i, int j, float f) {
        super.render(i, j, f);

        RenderUtils.drawTextCentered(message, this.width / 2, this.height / 2 - 30);
    }
}
