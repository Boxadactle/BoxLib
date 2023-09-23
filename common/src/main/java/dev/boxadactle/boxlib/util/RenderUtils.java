package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec2;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RenderUtils {

    static RenderHelper instance;

    public static void init() {
        instance = new RenderHelper();
    }

    public static void drawSquare(GuiGraphics guiGraphics, int x, int y, int width, int height, int color) {
        guiGraphics.fill(x, y, x + width, y + height, color);
    }

    public static void drawSquare(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        drawSquare(guiGraphics, x, y, width, height, GuiUtils.WHITE);
    }

    public static void drawSquare(GuiGraphics guiGraphics, Rect<Integer> rect, int color) {
        drawSquare(guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    public static void drawSquare(GuiGraphics guiGraphics, Rect<Integer> rect) {
        drawSquare(guiGraphics, rect, GuiUtils.WHITE);
    }

    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, int u, int v) {
        instance.drawTexture(texture, guiGraphics, x, y, width, height, u, v, false);
    }

    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, rect, uv.getX(), uv.getY());
    }

    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, new Rect<>(x, y, width, height), uv);
    }

    public static void drawText(GuiGraphics guiGraphics, Component text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawText(GuiGraphics guiGraphics, Component text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }

    public static void drawText(GuiGraphics guiGraphics, String text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawText(GuiGraphics guiGraphics, String text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }

    public static void drawTextCentered(GuiGraphics guiGraphics, Component text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(GuiGraphics guiGraphics, Component text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    public static void drawTextCentered(GuiGraphics guiGraphics, String text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(GuiGraphics guiGraphics, String text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    private static class RenderHelper {

        public RenderHelper() {}

        public void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, int u, int v, boolean ignored) {
            RenderSystem.enableBlend();
            guiGraphics.blit(texture, x, y, u, v, width, height);
        }
    }

}
