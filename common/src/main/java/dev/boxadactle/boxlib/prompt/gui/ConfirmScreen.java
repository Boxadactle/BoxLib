package dev.boxadactle.boxlib.prompt.gui;

import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfirmScreen extends PromptScreen<Boolean> {

    boolean value = false;

    int textY;

    Component message;

    public ConfirmScreen(Screen parent, Component message) {
        super(parent);

        this.message = message;
    }

    @Override
    protected void closeScreen(boolean hasData) {
        value = hasData;
        super.closeScreen(true);
    }

    @Override
    protected Boolean getData() {
        return value;
    }

    @Override
    protected boolean allowContinue() {
        return true;
    }

    @Override
    protected void init() {
        textY = this.height / 2 - 50;

        layout.addTitleHeader(message, GuiUtils.getTextRenderer());

        super.init();
    }
}
