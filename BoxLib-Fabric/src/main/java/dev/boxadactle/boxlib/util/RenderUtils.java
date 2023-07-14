package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.boxadactle.boxlib.math.Rect;
import dev.boxadactle.boxlib.math.Vec2;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RenderUtils {

    static RenderHelper instance;

    public static void init() {
        instance = new RenderHelper();
    }

    public static void drawSquare(DrawContext drawContext, int x, int y, int width, int height, int color) {
        drawContext.fill(x, y, x + width, y + height, color);
    }

    public static void drawSquare(DrawContext drawContext, int x, int y, int width, int height) {
        drawSquare(drawContext, x, y, width, height, GuiUtils.WHITE);
    }

    public static void drawSquare(DrawContext drawContext, Rect<Integer> rect, int color) {
        drawSquare(drawContext, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    public static void drawSquare(DrawContext drawContext, Rect<Integer> rect) {
        drawSquare(drawContext, rect, GuiUtils.WHITE);
    }

    public static void drawTexture(Identifier texture, DrawContext drawContext, int x, int y, int width, int height, int u, int v) {
        instance.drawTexture(texture, drawContext, x, y, width, height, u, v, false);
    }

    public static void drawTexture(Identifier texture, DrawContext drawContext, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, drawContext, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    public static void drawTexture(Identifier texture, DrawContext drawContext, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, drawContext, rect, uv.getX(), uv.getY());
    }

    public static void drawTexture(Identifier texture, DrawContext drawContext, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, drawContext, new Rect<>(x, y, width, height), uv);
    }
    
    public static void drawText(DrawContext drawContext, Text text, int x, int y, int color) {
        drawContext.drawText(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }
    
    public static void drawText(DrawContext drawContext, Text text, int x, int y) {
        drawText(drawContext, text, x, y, GuiUtils.WHITE);
    }
    
    public static void drawText(DrawContext drawContext, String text, int x, int y, int color) {
        drawContext.drawText(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }
    
    public static void drawText(DrawContext drawContext, String text, int x, int y) {
        drawText(drawContext, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(DrawContext drawContext, Text text, int x, int y) {
        drawTextCentered(drawContext, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(DrawContext drawContext, Text text, int x, int y, int color) {
        drawContext.drawText(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().getWidth(text) / 2), y, color, true);
    }

    public static void drawTextCentered(DrawContext drawContext, String text, int x, int y) {
        drawTextCentered(drawContext, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(DrawContext drawContext, String text, int x, int y, int color) {
        drawContext.drawText(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().getWidth(text) / 2), y, color, true);
    }

    private static class RenderHelper {

        public RenderHelper() {}

        public void drawTexture(Identifier texture, DrawContext drawContext, int x, int y, int width, int height, int u, int v, boolean ignored) {
            RenderSystem.enableBlend();
            drawContext.drawTexture(texture, x, y, u, v, width, height);
        }
    }
    
}
