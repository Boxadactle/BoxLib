package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigHelper;
import dev.boxadactle.boxlib.gui.BConfigEntry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

public class BWidgetContainer extends AbstractWidget implements Renderable, BConfigEntry<Object> {

    public BConfigEntry<?> widget1;
    public BConfigEntry<?> widget2;

    public BWidgetContainer(BConfigEntry<?> widget1, BConfigEntry<?> widget2) {
        super(0, 0, 0, BConfigHelper.buttonHeight(), Component.literal(""));

        this.widget1 = widget1;
        this.widget2 = widget2;

        widget1.setHalfWidget(true);
        widget2.setHalfWidget(true);
    }

    @Override
    public void render(GuiGraphics p_282421_, int mouseX, int mouseY, float delta) {
        AbstractWidget w1 = (AbstractWidget) widget1;
        AbstractWidget w2 = (AbstractWidget) widget2;

        w1.setX(this.getX());
        w1.setY(this.getY());
        w1.setWidth(this.width - 1);

        w2.setX(this.getX() + (this.width / 2) + 2);
        w2.setY(this.getY());
        w2.setWidth(this.width - 1);

        w1.render(p_282421_, mouseX, mouseY, delta);
        w2.render(p_282421_, mouseX, mouseY, delta);
    }

    @Override
    protected void renderWidget(GuiGraphics p_282139_, int p_268034_, int p_268009_, float p_268085_) {
    }

    @Override
    public void tick() {
        widget1.tick();
        widget2.tick();
    }

    @Override
    public Object handleInput(Object input) {
        return null;
    }

    @Override
    public void setHalfWidget(boolean halfButton) {
    }

    @Override
    public boolean isHalfWidget() {
        return false;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput p_259858_) {

    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);

        AbstractWidget w1 = (AbstractWidget) widget1;
        AbstractWidget w2 = (AbstractWidget) widget2;

        if (w1.isHovered()) {
            w1.onClick(mouseX, mouseY);

            if (widget1 instanceof EditBox)
                ((EditBox) widget1).setFocused(true);

            if (widget2 instanceof EditBox)
                ((EditBox) widget2).setFocused(false);
        }
        else if (w2.isHovered()) {
            w2.onClick(mouseX, mouseY);

            if (widget2 instanceof EditBox)
                ((EditBox) widget2).setFocused(true);

            if (widget1 instanceof EditBox)
                ((EditBox) widget1).setFocused(false);
        }
    }

    @Override
    public void onUnselect() {
        if (widget1 instanceof EditBox)
            ((EditBox) widget1).setFocused(false);

        if (widget2 instanceof EditBox)
            ((EditBox) widget2).setFocused(false);
    }

    @Override
    public boolean isInvalid() {
        boolean a = widget1.isInvalid();
        boolean b = widget2.isInvalid();

        return a || b;
    }
}
