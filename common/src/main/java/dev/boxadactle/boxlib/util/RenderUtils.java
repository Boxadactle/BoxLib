package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
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
     * @param poseStack   The pose stack used for rendering.
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(PoseStack poseStack, int x, int y, int width, int height, int color) {
        GuiComponent.fill(poseStack, x, y, x + width, y + height, color);
    }

    /**
     * Draws a filled square on the GUI with the default color (white).
     *
     * @param poseStack   The pose stack used for rendering.
     * @param x           The x-coordinate of the top-left corner of the square.
     * @param y           The y-coordinate of the top-left corner of the square.
     * @param width       The width of the square.
     * @param height      The height of the square.
     */
    public static void drawSquare(PoseStack poseStack, int x, int y, int width, int height) {
        drawSquare(poseStack, x, y, width, height, GuiUtils.WHITE);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param rect        The rectangle defining the position and size of the square.
     * @param color       The color of the square.
     */
    public static void drawSquare(PoseStack poseStack, Rect<Integer> rect, int color) {
        drawSquare(poseStack, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), color);
    }

    /**
     * Draws a filled square on the GUI using a rectangle object with the default color (white).
     *
     * @param poseStack   The pose stack used for rendering.
     * @param rect        The rectangle defining the position and size of the square.
     */
    public static void drawSquare(PoseStack poseStack, Rect<Integer> rect) {
        drawSquare(poseStack, rect, GuiUtils.WHITE);
    }

    /**
     * Draws a textured rectangle on the GUI.
     *
     * @param texture     The resource location of the texture.
     * @param poseStack   The pose stack used for rendering.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, PoseStack poseStack, int x, int y, int width, int height, int u, int v) {
        ClientUtils.getClient().getTextureManager().bind(texture);
        GuiComponent.blit(poseStack, x, y, u, v, width, height, width, height);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object.
     *
     * @param texture     The resource location of the texture.
     * @param poseStack   The pose stack used for rendering.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param u           The u-coordinate of the top-left corner of the texture.
     * @param v           The v-coordinate of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, PoseStack poseStack, Rect<Integer> rect, int u, int v) {
        drawTexture(texture, poseStack, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), u, v);
    }

    /**
     * Draws a textured rectangle on the GUI using a rectangle object and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param poseStack   The pose stack used for rendering.
     * @param rect        The rectangle defining the position and size of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, PoseStack poseStack, Rect<Integer> rect, Vec2<Integer> uv) {
        drawTexture(texture, poseStack, rect, uv.getX(), uv.getY());
    }

    /**
     * Draws a textured rectangle on the GUI using individual coordinates and a vector for texture coordinates.
     *
     * @param texture     The resource location of the texture.
     * @param poseStack   The pose stack used for rendering.
     * @param x           The x-coordinate of the top-left corner of the rectangle.
     * @param y           The y-coordinate of the top-left corner of the rectangle.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param uv          The vector containing the u and v coordinates of the top-left corner of the texture.
     */
    public static void drawTexture(ResourceLocation texture, PoseStack poseStack, int x, int y, int width, int height, Vec2<Integer> uv) {
        drawTexture(texture, poseStack, new Rect<>(x, y, width, height), uv);
    }

    /**
     * Draws text on the GUI.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(PoseStack poseStack, Component text, int x, int y) {
        drawText(poseStack, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws text on the GUI with a specified color.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     * @param color       The color of the text.
     */
    public static void drawText(PoseStack poseStack, Component text, int x, int y, int color) {
        GuiComponent.drawString(poseStack, GuiUtils.getTextRenderer(), text, x, y, color);
    }

    /**
     * Draws text on the GUI.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     */
    public static void drawText(PoseStack poseStack, String text, int x, int y) {
        drawText(poseStack, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws text on the GUI with a specified color.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the starting position of the text.
     * @param y           The y-coordinate of the starting position of the text.
     * @param color       The color of the text.
     */
    public static void drawText(PoseStack poseStack, String text, int x, int y, int color) {
        GuiComponent.drawString(poseStack, GuiUtils.getTextRenderer(), text, x, y, color);
    }

    /**
     * Draws centered text on the GUI.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     */
    public static void drawTextCentered(PoseStack poseStack, Component text, int x, int y) {
        drawTextCentered(poseStack, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI with a specified color.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     * @param color       The color of the text.
     */
    public static void drawTextCentered(PoseStack poseStack, Component text, int x, int y, int color) {
        GuiComponent.drawCenteredString(poseStack, GuiUtils.getTextRenderer(), text, x, y, color);
    }

    /**
     * Draws centered text on the GUI.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     */
    public static void drawTextCentered(PoseStack poseStack, String text, int x, int y) {
        drawTextCentered(poseStack, text, x, y, GuiUtils.WHITE);
    }

    /**
     * Draws centered text on the GUI with a specified color.
     *
     * @param poseStack   The pose stack used for rendering.
     * @param text        The text to be drawn.
     * @param x           The x-coordinate of the center position of the text.
     * @param y           The y-coordinate of the center position of the text.
     * @param color       The color of the text.
     */
    public static void drawTextCentered(PoseStack poseStack, String text, int x, int y, int color) {
        GuiComponent.drawCenteredString(poseStack, GuiUtils.getTextRenderer(), text, x, y, color);
    }

}
