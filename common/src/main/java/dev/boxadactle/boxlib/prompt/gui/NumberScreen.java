package dev.boxadactle.boxlib.prompt.gui;

import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
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

        super.init();
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
        super.extractRenderState(guiGraphics, i, j, f);

        if (inputBox != null) {
            if (!allowContinue()) {
                RenderUtils.drawSquare(guiGraphics, new Rect<>(inputBox.getX(), inputBox.getY(), inputBox.getWidth(), inputBox.getHeight()), GuiUtils.applyAlpha(GuiUtils.RED, 0.4f));
            }
        }
    }
}
