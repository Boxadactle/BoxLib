package dev.boxadactle.boxlib.util;

import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec2;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/**
 * Utility class for rendering graphics in a GUI.
 */
public class RenderUtils {

    /**
     * Draws a filled square on the GUI.
     *
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(int x, int y, int width, int height, int color) {
        GuiComponent.fill(x, y, x + width, y + height, color);
    }

    /**
     * Draws a filled square on the GUI with the default color (white).
     *
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     */
    public static void drawSquare(int x, int y, int width, int height) {
        drawSquare(x, y, width, height, GuiUtils.WHITE);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object.
     *
     * @param rect        The rectangle defining the position and size of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(Rect<Integer> rect, int color) {
        drawSquare(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object with the default color (white).
     *
     * @param rect        The rectangle defining the position and size of the square.
     */
    public static void drawSquare(Rect<Integer> rect) {
        drawSquare(rect, GuiUtils.WHITE);
    }

    /**
     * Draws a textured rectangle on the GUI.
     *
     * @param texture     The resource location of the texture.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, int x, int y, int width, int height, int u, int v) {
        ClientUtils.getClient().getTextureManager().bind(texture);
        GuiComponent.blit(x, y, (float)u, (float)v, width, height, width, height);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object.
     *
     * @param texture     The resource location of the texture.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, rect, uv.getX(), uv.getY());
    }

    /**
     * Draws a textured rectangle on the GUI using individual coordinates and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, new Rect<>(x, y, width, height), uv);
    }

    /**
     * Draws text on the GUI.
     *
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(Component text, int x, int y) {
        drawText(text.getColoredString(), x, y, GuiUtils.WHITE);
    }

    /**
     * Draws text on the GUI with a specified color.
     *
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     * @param color       The color of the text.
     */
    public static void drawText(String text, int x, int y, int color) {
        GuiUtils.getTextRenderer().drawShadow(text, (float)x, (float)y, color);
    }

    /**
     * Draws text on the GUI.
     *
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(String text, int x, int y) {
        drawText(text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI.
     *
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     */
    public static void drawTextCentered(Component text, int x, int y) {
        drawTextCentered(text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI with a specified color.
     *
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     * @param color       The color of the text.
     */
    public static void drawTextCentered(Component text, int x, int y, int color) {
        GuiUtils.getTextRenderer().drawShadow(text.getColoredString(), (float)x - ((float) GuiUtils.getTextSize(text) / 2), (float)y, color);
    }

}
