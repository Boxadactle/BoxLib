package dev.boxadactle.boxlib.prompt.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.prompt.PromptScreen;
import dev.boxadactle.boxlib.util.RenderUtils;
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
        super.init();

        textY = this.height / 2 - 50;

        addButton(createOkButton(getStartX(), this.height / 2 + 30, (b) -> closeScreen(true)));
    }

    @Override
    public void render(int i, int j, float f) {
        super.render(i, j, f);

        RenderUtils.drawTextCentered(message, this.width / 2, textY);
    }
}
