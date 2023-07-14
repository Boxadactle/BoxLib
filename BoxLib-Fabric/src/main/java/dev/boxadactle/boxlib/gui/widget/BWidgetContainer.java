package dev.boxadactle.boxlib.gui.widget;

import dev.boxadactle.boxlib.gui.BConfigHelper;
import dev.boxadactle.boxlib.gui.BConfigEntry;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class BWidgetContainer extends ClickableWidget implements Drawable, BConfigEntry<Object> {

    public BConfigEntry<?> widget1;
    public BConfigEntry<?> widget2;

    public BWidgetContainer(BConfigEntry<?> widget1, BConfigEntry<?> widget2) {
        super(0, 0, 0, BConfigHelper.buttonHeight(), Text.of(""));

        this.widget1 = widget1;
        this.widget2 = widget2;

        widget1.setHalfWidget(true);
        widget2.setHalfWidget(true);
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        ClickableWidget w1 = (ClickableWidget) widget1;
        ClickableWidget w2 = (ClickableWidget) widget2;

        w1.setX(this.getX());
        w1.setY(this.getY());
        w1.setWidth(this.width - 1);

        w2.setX(this.getX() + (this.width / 2) + 2);
        w2.setY(this.getY());
        w2.setWidth(this.width - 1);

        w1.render(drawContext, mouseX, mouseY, delta);
        w2.render(drawContext, mouseX, mouseY, delta);
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
    protected void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);

        ClickableWidget w1 = (ClickableWidget) widget1;
        ClickableWidget w2 = (ClickableWidget) widget2;

        if (w1.isHovered()) {
            w1.onClick(mouseX, mouseY);

            if (widget1 instanceof TextFieldWidget)
                ((TextFieldWidget) widget1).setFocused(true);

            if (widget2 instanceof TextFieldWidget)
                ((TextFieldWidget) widget2).setFocused(false);
        }
        else if (w2.isHovered()) {
            w2.onClick(mouseX, mouseY);

            if (widget2 instanceof TextFieldWidget)
                ((TextFieldWidget) widget2).setFocused(true);

            if (widget1 instanceof TextFieldWidget)
                ((TextFieldWidget) widget1).setFocused(false);
        }
    }

    @Override
    public void onUnselect() {
        if (widget1 instanceof TextFieldWidget)
            ((TextFieldWidget) widget1).setFocused(false);

        if (widget2 instanceof TextFieldWidget)
            ((TextFieldWidget) widget2).setFocused(false);
    }

    @Override
    public void appendClickableNarrations(NarrationMessageBuilder builder) {
        this.appendDefaultNarrations(builder);
    }

    @Override
    public boolean isInvalid() {
        boolean a = widget1.isInvalid();
        boolean b = widget2.isInvalid();

        return a || b;
    }
}
