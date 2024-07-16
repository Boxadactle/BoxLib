package dev.boxadactle.boxlib.prompt;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.function.Consumer2;
import dev.boxadactle.boxlib.gui.config.BOptionHelper;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;


public abstract class PromptScreen<T> extends Screen implements BOptionHelper {
    Screen parent;
    Consumer2<Boolean, T> dataConsumer;

    Button okButton;

    protected PromptScreen(Screen parent) {
        super(new TextComponent("BoxLib prompt screen"));

        this.parent = parent;
    }

    @Override
    public void render(int i, int j, float f) {
        renderBackground();
        super.render(i, j, f);
    }

    protected abstract T getData();

    protected abstract boolean allowContinue();

    protected boolean hasButtons() {
        return true;
    }

    public void onData(Consumer2<Boolean, T> dataConsumer) {
        this.dataConsumer = dataConsumer;
    }

    protected void closeScreen(boolean hasData) {
        ClientUtils.setScreen(parent);

        if (dataConsumer != null) {
            if (hasData && !allowContinue()) {
                hasData = false;
            }

            dataConsumer.accept(hasData, hasData ? getData() : null);
        }
    }

    @Override
    public void onClose() {
        closeScreen(false);
    }

    protected int getStartX() {
        return this.width / 2 - getPadding() / 2 - getButtonWidth(BOptionHelper.ButtonType.SMALL);
    }

    protected int getStartY() {
        return this.height / 2 + 50;
    }

    @Override
    protected void init() {
        if (hasButtons()) {
            int startX = getStartX();
            int startY = getStartY();

            // cancel button
            addButton(createHalfCancelButton(startX, startY, (b) -> closeScreen(false)));

            // ok button
            okButton = addButton(createHalfOkButton(startX, startY, (b) -> closeScreen(true)));
        }

    }

    @Override
    public void tick() {
        if (okButton != null) okButton.active = allowContinue();
    }
}
