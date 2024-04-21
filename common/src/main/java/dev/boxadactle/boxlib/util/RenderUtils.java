package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec2;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/**
 * Utility class for rendering graphics in a GUI.
 */
public class RenderUtils {

    static RenderHelper instance;

    /**
     * Initializes the RenderUtils class by creating an instance of RenderHelper.
     */
    public static void init() {
        instance = new RenderHelper();
    }

    /**
     * Draws a filled square on the GUI.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(GuiGraphics guiGraphics, int x, int y, int width, int height, int color) {
        guiGraphics.fill(x, y, x + width, y + height, color);
    }

    /**
     * Draws a filled square on the GUI with the default color (white).
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     */
    public static void drawSquare(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        drawSquare(guiGraphics, x, y, width, height, GuiUtils.WHITE);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param rect        The rectangle defining the position and size of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(GuiGraphics guiGraphics, Rect<Integer> rect, int color) {
        drawSquare(guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object with the default color (white).
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param rect        The rectangle defining the position and size of the square.
     */
    public static void drawSquare(GuiGraphics guiGraphics, Rect<Integer> rect) {
        drawSquare(guiGraphics, rect, GuiUtils.WHITE);
    }

    /**
     * Draws a textured rectangle on the GUI.
     *
     * @param texture     The resource location of the texture.
     * @param guiGraphics The graphics object used for drawing.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, int u, int v) {
        instance.drawTexture(texture, guiGraphics, x, y, width, height, u, v, false);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object.
     *
     * @param texture     The resource location of the texture.
     * @param guiGraphics The graphics object used for drawing.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, guiGraphics, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param guiGraphics The graphics object used for drawing.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, rect, uv.getX(), uv.getY());
    }

    /**
     * Draws a textured rectangle on the GUI using individual coordinates and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param guiGraphics The graphics object used for drawing.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, guiGraphics, new Rect<>(x, y, width, height), uv);
    }

    /**
     * Draws text on the GUI.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(GuiGraphics guiGraphics, Component text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws text on the GUI with a specified color.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     * @param color       The color of the text.
     */
    public static void drawText(GuiGraphics guiGraphics, Component text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }

    /**
     * Draws text on the GUI.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(GuiGraphics guiGraphics, String text, int x, int y) {
        drawText(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws text on the GUI with a specified color.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     * @param color       The color of the text.
     */
    public static void drawText(GuiGraphics guiGraphics, String text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, x, y, color, true);
    }

    /**
     * Draws centered text on the GUI.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     */
    public static void drawTextCentered(GuiGraphics guiGraphics, Component text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI with a specified color.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     * @param color       The color of the text.
     */
    public static void drawTextCentered(GuiGraphics guiGraphics, Component text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    /**
     * Draws centered text on the GUI.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     */
    public static void drawTextCentered(GuiGraphics guiGraphics, String text, int x, int y) {
        drawTextCentered(guiGraphics, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI with a specified color.
     *
     * @param guiGraphics The graphics object used for drawing.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     * @param color       The color of the text.
     */
    public static void drawTextCentered(GuiGraphics guiGraphics, String text, int x, int y, int color) {
        guiGraphics.drawString(GuiUtils.getTextRenderer(), text, (x - GuiUtils.getTextRenderer().width(text) / 2), y, color, true);
    }

    private static class RenderHelper {

        public RenderHelper() {}

        /**
         * Draws a textured rectangle on the GUI.
         *
         * @param texture     The resource location of the texture.
         * @param guiGraphics The graphics object used for drawing.
         * @param x           The x-coordinate of the top-left corner of the rectangle.
         * @param y           The y-coordinate of the top-left corner of the rectangle.
         * @param width       The width of the rectangle.
         * @param height      The height of the rectangle.
         * @param u           The u-coordinate of the top-left corner of the texture.
         * @param v           The v-coordinate of the top-left corner of the texture.
         * @param ignored     A boolean value indicating whether the parameter is ignored.
         */
        public void drawTexture(ResourceLocation texture, GuiGraphics guiGraphics, int x, int y, int width, int height, int u, int v, boolean ignored) {
            RenderSystem.enableBlend();
            guiGraphics.blit(texture, x, y, u, v, width, height);
        }
    }

}
