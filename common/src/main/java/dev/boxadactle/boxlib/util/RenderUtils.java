package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec2;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RenderUtils {

    static RenderHelper instance;

    public static void init() {
        instance = new RenderHelper();
    }

    public static void drawSquare(PoseStack poseStack, int x, int y, int width, int height, int color) {
        instance.fillBox(poseStack, x, y, x + width, y + height, color);
    }

    public static void drawSquare(PoseStack guiGraphics, int x, int y, int width, int height) {
        drawSquare(guiGraphics, x, y, width, height, GuiUtils.WHITE);
    }

    public static void drawSquare(PoseStack guiGraphics, Rect<Integer> rect, int color) {
        drawSquare(guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    public static void drawSquare(PoseStack guiGraphics, Rect<Integer> rect) {
        drawSquare(guiGraphics, rect, GuiUtils.WHITE);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack guiGraphics, int x, int y, int width, int height, int u, int v) {
        instance.drawTexture(texture, guiGraphics, x, y, width, height, u, v, false);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack guiGraphics, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    public static void drawTexture(ResourceLocation texture, PoseStack guiGraphics, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, rect, uv.getX(), uv.getY());
    }

    public static void drawTexture(ResourceLocation texture, PoseStack guiGraphics, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, new Rect<>(x, y, width, height), uv);
    }

    public static void drawText(PoseStack guiGraphics, Component text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawText(PoseStack guiGraphics, Component text, int x, int y, int color) {
        instance.drawText(guiGraphics, GuiUtils.getTextRenderer(), text, x, y, color, true);
    }

    public static void drawText(PoseStack guiGraphics, String text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawText(PoseStack guiGraphics, String text, int x, int y, int color) {
        instance.drawText(guiGraphics, GuiUtils.getTextRenderer(), Component.literal(text), x, y, color, true);
    }

    public static void drawTextCentered(PoseStack guiGraphics, Component text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(PoseStack guiGraphics, Component text, int x, int y, int color) {
        instance.drawText(guiGraphics, GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    public static void drawTextCentered(PoseStack guiGraphics, String text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    public static void drawTextCentered(PoseStack poseStack, String text, int x, int y, int color) {
        instance.drawText(poseStack, GuiUtils.getTextRenderer(), Component.literal(text), (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    private static class RenderHelper extends GuiComponent {

        public RenderHelper() {}
        
        public void drawText(PoseStack poseStack, Font font, Component text, int x, int y, int color, boolean shadow) {
            drawString(poseStack, font, text, x, y, color);
        }

        public void fillBox(PoseStack poseStack, int x, int y, int x2, int y2, int color) {
            fill(poseStack, x, y, x2, y2, color);
        }

        public void drawTexture(ResourceLocation texture, PoseStack poseStack, int x, int y, int width, int height, int u, int v, boolean ignored) {
            RenderSystem.enableBlend();
            RenderSystem.setShaderTexture(0, texture);
            blit(poseStack, x, y, width, height, u, v);
        }
    }

}
