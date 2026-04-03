package dev.boxadactle.boxlib.gui.config.widget.button;

import dev.boxadactle.boxlib.gui.config.BOptionButton;
import dev.boxadactle.boxlib.gui.config.BOptionTextField;
import dev.boxadactle.boxlib.gui.config.widget.slider.BIntegerSlider;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class BColorPickerButton extends BOptionButton<Integer> {
    Screen parent;

    boolean alpha;

    /**
     * Constructs a new BOptionButton with the given message, value, and function.
     *
     * @param key  the key of the text to display on the button
     * @param value    the initial value of the button
     * @param function the function to consume the current value
     */
    public BColorPickerButton(String key, Screen parent, boolean alpha, Integer value, Consumer<Integer> function) {
        super(Component.translatable(key, Component.literal(" ")), value, function);

        this.parent = parent;
        this.alpha = alpha;
    }

    @Override
    protected Integer changeValue(Integer input) {
        return null;
    }

    public void updateColor(int newColor) {
        this.currentValue = newColor;
        function.accept(newColor);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor p_93657_, int mouseX, int mouseY, float delta) {
        super.extractContents(p_93657_, mouseX, mouseY, delta);

        int textWidth = GuiUtils.getTextRenderer().width(getMessage());
        int r = getWidth() / 2 + textWidth / 2;
        RenderUtils.drawSquare(p_93657_, getX() + r + 5, getY() + 3, 20, getButtonHeight() - 6, alpha ? currentValue : GuiUtils.applyAlpha(currentValue, 1.0f));
    }

    @Override
    public void onClick(MouseButtonEvent mouseButtonEvent, boolean bl) {
        ClientUtils.setScreen(new ColorPickerScreen(getMessage(), currentValue));
    }

    public class ColorPickerScreen extends Screen {

        HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);

        int r;
        int g;
        int b;
        int a;

        BIntegerSlider as;
        BIntegerSlider gs;
        BIntegerSlider bs;
        BIntegerSlider rs;

        BOptionTextField<Integer> colorField;

        protected ColorPickerScreen(Component component, int color) {
            super(component);

            r = (color >> 16) & 0xFF;
            g = (color >> 8) & 0xFF;
            b = color & 0xFF;
            a = alpha ? (color >> 24) & 0xFF : 255;
        }

        private int getColor() {
            return (a << 24) | (r << 16) | (g << 8) | b;
        }

        @Override
        protected void init() {
            layout.addTitleHeader(title, GuiUtils.getTextRenderer());

            LinearLayout linearLayout = LinearLayout.vertical().spacing(getPadding());
            linearLayout.addChild(new SpacerElement(50, 130));
            as = linearLayout.addChild(slider(new BIntegerSlider(
                    "boxlib.color.red",
                    0, 255,
                    r,
                    (v) -> r = v
            )));
            gs = linearLayout.addChild(slider(new BIntegerSlider(
                    "boxlib.color.green",
                    0, 255,
                    g,
                    (v) -> g = v
            )));
            bs = linearLayout.addChild(slider(new BIntegerSlider(
                    "boxlib.color.blue",
                    0, 255,
                    b,
                    (v) -> b = v
            )));
            rs = linearLayout.addChild(slider(new BIntegerSlider(
                    "boxlib.color.alpha",
                    0, 255,
                    a,
                    (v) -> a = v
            )));
            rs.active = alpha;
            layout.addToContents(linearLayout);

            layout.addToFooter(createDoneButton(this::close));

            layout.visitWidgets(this::addRenderableWidget);
            layout.arrangeElements();
        }

        @Override
        public void extractRenderState(GuiGraphicsExtractor guiGraphics, int i, int j, float f) {
            super.extractRenderState(guiGraphics, i, j, f);

            RenderUtils.drawSquare(guiGraphics, width / 2 - 50, 35, 100, 60, getColor());
        }

        private BIntegerSlider slider(BIntegerSlider slider) {
            slider.setWidth(200);
            slider.setHeight(20);
            return slider;
        }

        private void close(Button b) {
            updateColor(getColor());
            ClientUtils.setScreen(BColorPickerButton.this.parent);
        }

        @Override
        public boolean shouldCloseOnEsc() {
            return false;
        }
    }
}
