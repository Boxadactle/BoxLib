package dev.boxadactle.boxlib.gui;

import dev.boxadactle.boxlib.gui.widget.BWidgetContainer;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BConfigScreen extends Screen implements BConfigHelper {

    protected Screen parent;
    protected Button saveButton;

    protected ConfigListWidget scrollingWidget;

    protected BConfigScreen(Screen parent) {
        super(Component.literal("Config Screen"));

        this.parent = parent;
    }

    protected abstract Component getName();

    protected abstract void initFooter(int startX, int startY);
    protected abstract void initConfigButtons();

    protected BConfigEntry<?> addConfigOption(BConfigEntry<?> widget) {
        scrollingWidget.addEntry(new ConfigListWidget.ConfigWidgetEntry(widget));

        return widget;
    }

    protected void setWiki(Component label, String link) {
        this.addRenderableWidget(new Button.Builder(label, b -> {
            ClientUtils.openLinkConfirmScreen(link, this);
        }).bounds(3, 3, BConfigHelper.buttonWidth(ButtonType.TINY), BConfigHelper.buttonHeight() - 3).build());
    }

    protected boolean shouldRenderScrollingWidget() {
        return true;
    }

    @Override
    public void render(GuiGraphics p_96562_, int mouseX, int mouseY, float delta) {
        if (shouldRenderScrollingWidget()) this.scrollingWidget.render(p_96562_, mouseX, mouseY, delta);

        super.render(p_96562_, mouseX, mouseY, delta);

        RenderUtils.drawTextCentered(p_96562_, this.getName(), this.width / 2, 5);
    }

    @Override
    public void init() {
        scrollingWidget = new ConfigListWidget(ClientUtils.getClient());
        this.addWidget(scrollingWidget);

        this.initFooter(this.width / 2 - BConfigHelper.padding() / 2 - BConfigHelper.buttonWidth(ButtonType.SMALL), this.height - getButtonHeight() - getPadding());
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

    protected Button setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
        return addRenderableWidget(saveButton);
    }

    public class ConfigListWidget extends ObjectSelectionList<ConfigListWidget.ConfigWidgetEntry> {

        static ConfigListWidget instance;

        public ConfigListWidget(Minecraft client) {
            super(client, BConfigScreen.this.width, BConfigScreen.this.height, 20, BConfigScreen.this.height - 30, BConfigHelper.buttonHeight() + BConfigHelper.padding() * 2);

            instance = this;
        }

        protected int getScrollbarPosition() {
            return super.getScrollbarPosition() + 60;
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
        public void setSelected(ConfigWidgetEntry entry) {
            Objects.requireNonNull(entry).setFocused(true);

            super.setSelected(entry);
        }

        public static void changeSelected(@Nullable BConfigScreen.ConfigListWidget.ConfigWidgetEntry entry) {
            instance.setSelected(entry);
        }


        protected void renderBackground(GuiGraphics p_93442_) {
            BConfigScreen.this.renderBackground(p_93442_);
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
            ConfigWidgetEntry e = this.getHovered();
            ConfigWidgetEntry e2 = this.getSelected();

            if (e == null) return false;

            if (!e.equals(e2)) {
                this.setSelected(e);
                if (e2 != null) e2.setFocused(false);
            } else return e.mouseClicked(mouseX, mouseY, button);

            return super.mouseClicked(mouseX, mouseY, button);
        }

        @Override
        protected void renderSelection(GuiGraphics p_283589_, int p_240142_, int p_240143_, int p_240144_, int p_240145_, int p_240146_) {
        }

        public static class ConfigWidgetEntry extends Entry<ConfigWidgetEntry> {
            final BConfigEntry<?> widget;

            int x;
            int y;
            int w;
            int h;

            public ConfigWidgetEntry(BConfigEntry<?> widget) {
                this.widget = widget;
            }

            public void render(GuiGraphics p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
                ((AbstractWidget)widget).setX(x);
                ((AbstractWidget)widget).setY(y);
                ((AbstractWidget)widget).setWidth(entryWidth - BConfigHelper.padding() * 2);

                this.x = x;
                this.y = y;
                this.w = entryWidth;
                this.h = entryHeight;

                ((AbstractWidget)widget).render(p_93523_, mouseX, mouseY, tickDelta);
            }

            public void tick() {
                widget.tick();
            }

            public boolean mouseClicked(double mouseX, double mouseY, int button) {
                return ((AbstractWidget)widget).mouseClicked(mouseX, mouseY, button);
            }

            public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
                if (widget instanceof EditBox) {
                    EditBox f = (EditBox) widget;

                    if(f.keyPressed(keyCode, scanCode, modifiers)) return true;
                    else f.charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
                } else if (widget instanceof BWidgetContainer) {
                    BWidgetContainer d = (BWidgetContainer) widget;

                    if (d.widget1 instanceof EditBox) {
                        if (((EditBox) d.widget1).isFocused()) {

                            if (((EditBox) d.widget1).keyPressed(keyCode, scanCode, modifiers)) return true;

                            ((EditBox) d.widget1).charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
                            return true;
                        }
                    }

                    if (d.widget2 instanceof EditBox) {
                        if (((EditBox) d.widget2).isFocused()) {

                            if (((EditBox) d.widget2).keyPressed(keyCode, scanCode, modifiers)) return true;

                            ((EditBox) d.widget2).charTyped(ClientUtils.getTypedKey(keyCode, scanCode), modifiers);
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
                if (widget instanceof EditBox) {
                    EditBox f = (EditBox) widget;

                    return f.keyReleased(keyCode, scanCode, modifiers);
                } else if (widget instanceof BWidgetContainer) {
                    BWidgetContainer d = (BWidgetContainer) widget;

                    if (d.widget1 instanceof EditBox) {
                        if (((EditBox) d.widget1).isFocused())
                            return ((EditBox) d.widget1).keyReleased(keyCode, scanCode, modifiers);
                    }

                    if (d.widget2 instanceof EditBox) {
                        if (((EditBox) d.widget2).isFocused())
                            return ((EditBox) d.widget2).keyReleased(keyCode, scanCode, modifiers);
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

            public Component getNarration() {
                return Component.translatable("narrator.select", ((AbstractWidget)widget).getMessage());
            }
        }
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
