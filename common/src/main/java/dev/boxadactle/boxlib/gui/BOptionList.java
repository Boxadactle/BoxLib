package dev.boxadactle.boxlib.gui;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BOptionList extends ContainerObjectSelectionList<BOptionList.ConfigEntry> {

    public BOptionList(Minecraft minecraft, BOptionScreen screen) {
        super(minecraft, screen.width, screen.height, 20, screen.height - 30, BOptionHelper.buttonHeight() + BOptionHelper.padding() * 2);
    }

    @Override
    public int addEntry(ConfigEntry entry) {
        return super.addEntry(entry);
    }

    public boolean hasInvalidEntry() {
        AtomicBoolean a = new AtomicBoolean(false);

        children().forEach(configWidgetEntry -> {
            if (configWidgetEntry.isInvalid()) a.set(true);
        });

        return a.get();
    }

    @Override
    protected int getScrollbarPosition() {
        return super.getScrollbarPosition() + 35;
    }

    @Override
    public int getRowWidth() {
        return super.getRowWidth() + 30;
    }

    public static class SingleEntry extends ConfigEntry {

        BOptionEntry<?> widget;

        public SingleEntry(BOptionEntry<?> widget) {
            this.widget = widget;
        }

        @Override
        public void render(GuiGraphics p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            AbstractWidget w = (AbstractWidget)widget;

            w.setX(x);
            w.setY(y);
            w.setWidth(entryWidth);

            w.render(p_93523_, mouseX, mouseY, tickDelta);
        }

        @Override
        List<? extends AbstractWidget> getWidgets() {
            return ImmutableList.of((AbstractWidget) widget);
        }

        @Override
        public boolean isInvalid() {
            return widget.isInvalid();
        }

    }

    public static class DoubleEntry extends ConfigEntry {

        BOptionEntry<?> widget1;
        BOptionEntry<?> widget2;

        public DoubleEntry(BOptionEntry<?> widget1, BOptionEntry<?> widget2) {
            this.widget1 = widget1;
            this.widget2 = widget2;
        }

        @Override
        List<? extends AbstractWidget> getWidgets() {
            return ImmutableList.of((AbstractWidget) widget1, (AbstractWidget)  widget2);
        }

        @Override
        public boolean isInvalid() {
            return widget1.isInvalid() || widget2.isInvalid();
        }

        @Override
        public void render(GuiGraphics p_93523_, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            AbstractWidget w1 = (AbstractWidget)widget1;
            AbstractWidget w2 = (AbstractWidget)widget2;

            int p1 = BOptionHelper.padding() / 2;

            int p2 = BOptionHelper.padding() / 2;

            w1.setX(x);
            w1.setY(y);
            w1.setWidth(entryWidth / 2 - p1);

            w2.setX(x + entryWidth / 2 + p2);
            w2.setY(y);
            w2.setWidth(entryWidth / 2 - p2);

            w1.render(p_93523_, mouseX, mouseY, tickDelta);
            w2.render(p_93523_, mouseX, mouseY, tickDelta);
        }
    }

    public abstract static class ConfigEntry extends ContainerObjectSelectionList.Entry<ConfigEntry> {

        @Override
        public List<? extends NarratableEntry> narratables() {
            return getWidgets();
        }

        @Override
        public List<? extends GuiEventListener> children() {
            return getWidgets();
        }

        abstract List<? extends AbstractWidget> getWidgets();

        public abstract boolean isInvalid();

    }

}

