package dev.boxadactle.boxlib.prompt;

import dev.boxadactle.boxlib.function.Consumer2;
import dev.boxadactle.boxlib.gui.config.BOptionHelper;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.FrameLayout;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;


public abstract class PromptScreen<T> extends Screen implements BOptionHelper {
    Screen parent;
    Consumer2<Boolean, T> dataConsumer;

    Button okButton;

    protected HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);
    protected FrameLayout frame;

    protected PromptScreen(Screen parent) {
        super(Component.literal("BoxLib prompt screen"));

        this.parent = parent;
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
        frame = new FrameLayout(width / 4, height / 4, width / 2, height / 2);

        frame.addChild(layout);

        if (hasButtons()) {
            LinearLayout linearLayout = layout.addToFooter(LinearLayout.horizontal().spacing(BOptionHelper.padding()));

            // cancel button
            linearLayout.addChild(createCancelButton((b) -> closeScreen(false)));

            // ok button
            okButton = linearLayout.addChild(createOkButton((b) -> closeScreen(true)));
        }

        frame.visitWidgets(this::addRenderableWidget);
        frame.arrangeElements();
    }

    @Override
    public void tick() {
        if (okButton != null) okButton.active = allowContinue();
    }
}
