package dev.boxadactle.boxlib.prompt.gui;

import dev.boxadactle.boxlib.gui.config.BOptionHelper;
import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AlertScreen extends PromptScreen<Void> {

    int textY;

    Component message;

    public AlertScreen(Screen parent, Component message) {
        super(parent);

        this.message = message;
    }

    @Override
    protected Void getData() {
        return null;
    }

    @Override
    protected boolean allowContinue() {
        return true;
    }

    @Override
    protected boolean hasButtons() {
        return false;
    }

    @Override
    protected void init() {
        textY = this.height / 2 - 50;

        LinearLayout linearLayout = layout.addToFooter(LinearLayout.horizontal().spacing(BOptionHelper.padding()));
        linearLayout.addChild(createOkButton((b) -> closeScreen(true)));

        layout.addTitleHeader(message, GuiUtils.getTextRenderer());

        super.init();
    }
}
