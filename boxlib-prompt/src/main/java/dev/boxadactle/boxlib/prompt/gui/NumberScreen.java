package dev.boxadactle.boxlib.prompt.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.Nullable;

public abstract class NumberScreen<T extends Number> extends PromptScreen<T> {

    EditBox inputBox;

    Component message;

    public NumberScreen(Screen parent, Component message) {
        super(parent);

        this.message = message;
    }

    protected @Nullable abstract T parse(String value);

    @Override
    protected T getData() {
        return parse(inputBox.getValue());
    }

    @Override
    protected boolean allowContinue() {
        try {
            return inputBox != null && !inputBox.getValue().isBlank() && parse(inputBox.getValue()) != null;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (inputBox != null) {
            if (!allowContinue()) {
                inputBox.setTextColor(GuiUtils.RED);
            } else {
                inputBox.setTextColor(GuiUtils.WHITE);
            }
        }
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
    }

    @Override
    public void render(int i, int j, float f) {
        super.render(i, j, f);

        RenderUtils.drawTextCentered(message, this.width / 2, this.height / 2 - 50);
    }
}
