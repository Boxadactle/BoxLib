package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.gui.widget.BWidgetContainer;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BConfigScreen extends Screen implements BConfigHelper {

    protected Screen parent;
    protected ButtonWidget saveButton;

    protected ConfigListWidget scrollingWidget;

    protected BConfigScreen(Screen parent) {
        super(Text.of("Config Screen"));

        this.parent = parent;
    }

    protected abstract Text getName();

    protected abstract void initFooter(int startX, int startY);
    protected abstract void initConfigButtons();

    protected BConfigEntry<?> addConfigOption(BConfigEntry<?> widget) {
        scrollingWidget.addEntry(new ConfigListWidget.ConfigWidgetEntry(widget));

        return widget;
    }

    protected void setWiki(Text label, String link) {
        this.addDrawableChild(new ButtonWidget.Builder(label, b -> {
            ClientUtils.openLinkConfirmScreen(link, this);
        }).dimensions(3, 3, getButtonWidth(ButtonType.TINY), getButtonHeight() - 3).build());
    }

    protected boolean shouldRenderScrollingWidget() {
        return true;
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        if (shouldRenderScrollingWidget()) this.scrollingWidget.render(drawContext, mouseX, mouseY, delta);

        super.render(drawContext, mouseX, mouseY, delta);

        RenderUtils.drawTextCentered(drawContext, this.getName(), this.width / 2, 5);
    }

    @Override
    public void init() {
        scrollingWidget = new ConfigListWidget(ClientUtils.getClient());
        this.addSelectableChild(scrollingWidget);

        this.initFooter(this.width / 2 - getPadding() / 2 - getButtonWidth(ButtonType.SMALL), this.height - getButtonHeight() - getPadding());
        this.initConfigButtons();

        super.init();
    }

    @Override
    public void tick() {
        super.tick();

        if (saveButton != null) {
            boolean a = !scrollingWidget.hasInvalidEntry();
            if (saveButton.active != a) saveButton.active = a;
        }

        scrollingWidget.tick();
    }

    public void close() {
        ClientUtils.getClient().setScreen(parent);
    }

    public interface Provider<T extends Screen> {

        T createScreen(Screen parent);

    }

    protected ButtonWidget setSaveButton(ButtonWidget saveButton) {
        this.saveButton = saveButton;
        return addDrawableChild(saveButton);
    }

    public class ConfigListWidget extends AlwaysSelectedEntryListWidget<ConfigListWidget.ConfigWidgetEntry> {

        static ConfigListWidget instance;

        public ConfigListWidget(MinecraftClient client) {
            super(client, BConfigScreen.this.width, BConfigScreen.this.height, 20, BConfigScreen.this.height - 30, BConfigHelper.buttonHeight() + BConfigHelper.padding() * 2);

            instance = this;
        }

        protected int getScrollbarPositionX() {
            return super.getScrollbarPositionX() + 60;
        }

        public int getRowWidth() {
            return getButtonWidth(ButtonType.NORMAL) + getPadding();
        }

        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
            AtomicBoolean a = new AtomicBoolean(false);

            children().forEach(configWidgetEntry -> {
                if (configWidgetEntry.keyPressed(keyCode, scanCode, modifiers)) a.set(true);
            });

            return a.get();
        }

        public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
            AtomicBoolean a = new AtomicBoolean(false);

            children().forEach(configWidgetEntry -> {
                if (configWidgetEntry.keyReleased(keyCode, scanCode, modifiers)) a.set(true);
            });

            return a.get();
        }

        public boolean hasInvalidEntry() {
            AtomicBoolean a = new AtomicBoolean(false);

            children().forEach(configWidgetEntry -> {
                if (configWidgetEntry.isInvalid()) a.set(true);
            });

            return a.get();
        }

        @Override
        public void setSelected(BConfigScreen.ConfigListWidget.ConfigWidgetEntry entry) {
            Objects.requireNonNull(entry).setFocused(true);

            super.setSelected(entry);
        }


        protected void renderBackground(DrawContext drawContext) {
            BConfigScreen.this.renderBackground(drawContext);
        }

        public boolean isFocused() {
            return BConfigScreen.this.getFocused() == this;
        }

        public int addEntry(ConfigWidgetEntry entry) {
            return super.addEntry(entry);
        }

        public void tick() {
            this.children().forEach(ConfigWidgetEntry::tick);
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            ConfigWidgetEntry e = this.getHoveredEntry();
            ConfigWidgetEntry e2 = this.getSelectedOrNull();

            if (e == null) return false;

            if (!e.equals(e2)) {
                this.setSelected(e);
                if (e2 != null) e2.setFocused(false);
            } else return e.mouseClicked(mouseX, mouseY, button);

            return super.mouseClicked(mouseX, mouseY, button);
        }

        @Override
        protected void drawSelectionHighlight(DrawContext context, int y, int entryWidth, int entryHeight, int borderColor, int fillColor) {
        }

        @Environment(EnvType.CLIENT)
        public static class ConfigWidgetEntry extends AlwaysSelectedEntryListWidget.Entry<ConfigWidgetEntry> {
            final BConfigEntry<?> widget;

            int x;
            int y;
            int w;
            int h;

            public ConfigWidgetEntry(BConfigEntry<?> widget) {
                this.widget = widget;
            }

            public void render(DrawContext drawContext, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
                ClickableWidget w = (ClickableWidget) widget;

                w.setX(x);
                w.setY(y);
                w.setWidth(entryWidth - BConfigHelper.padding() * 2);

                this.x = x;
                this.y = y;
                this.w = entryWidth;
                this.h = entryHeight;

                w.render(drawContext, mouseX, mouseY, tickDelta);
            }

            public void tick() {
                widget.tick();
            }

            public boolean mouseClicked(double mouseX, double mouseY, int button) {
                return ((ClickableWidget)widget).mouseClicked(mouseX, mouseY, button);
            }

            public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
                if (widget instanceof TextFieldWidget) {
                    TextFieldWidget f = (TextFieldWidget) widget;

                    if(f.keyPressed(keyCode, scanCode, modifiers)) return true;
                    else f.charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
                } else if (widget instanceof BWidgetContainer) {
                    BWidgetContainer d = (BWidgetContainer) widget;

                    if (d.widget1 instanceof TextFieldWidget) {
                        if (((TextFieldWidget) d.widget1).isFocused()) {

                            if (((TextFieldWidget) d.widget1).keyPressed(keyCode, scanCode, modifiers)) return true;

                            ((TextFieldWidget) d.widget1).charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
                            return true;
                        }
                    }

                    if (d.widget2 instanceof TextFieldWidget) {
                        if (((TextFieldWidget) d.widget2).isFocused()) {

                            if (((TextFieldWidget) d.widget2).keyPressed(keyCode, scanCode, modifiers)) return true;

                            ((TextFieldWidget) d.widget2).charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
                            return true;
                        }
                    }
                }

                return false;
            }

            public boolean isInvalid() {
                return widget.isInvalid();
            }

            public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
                if (widget instanceof TextFieldWidget) {
                    TextFieldWidget f = (TextFieldWidget) widget;

                    return f.keyReleased(keyCode, scanCode, modifiers);
                } else if (widget instanceof BWidgetContainer) {
                    BWidgetContainer d = (BWidgetContainer) widget;

                    if (d.widget1 instanceof TextFieldWidget) {
                        if (((TextFieldWidget) d.widget1).isFocused())
                            return ((TextFieldWidget) d.widget1).keyReleased(keyCode, scanCode, modifiers);
                    }

                    if (d.widget2 instanceof TextFieldWidget) {
                        if (((TextFieldWidget) d.widget2).isFocused())
                            return ((TextFieldWidget) d.widget2).keyReleased(keyCode, scanCode, modifiers);
                    }
                }

                return false;
            }

            public void setFocused(boolean focused) {
                if (widget instanceof BConfigTextField<?>) {
                    ((BConfigTextField<?>) widget).setFocused(focused);
                }

                if (focused) widget.onSelect();
                else widget.onUnselect();
            }

            public Text getNarration() {
                return Text.translatable("narrator.select", ((ClickableWidget)widget).getMessage());
            }
        }
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
