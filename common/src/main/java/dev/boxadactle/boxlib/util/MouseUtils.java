package dev.boxadactle.boxlib.util;

import dev.boxadactle.boxlib.math.geometry.Rect;
import dev.boxadactle.boxlib.math.geometry.Vec2;
import net.minecraft.client.MouseHandler;

/**
 * This class provides utility methods for mouse-related operations.
 */
public class MouseUtils {

    @Deprecated
    static int mouseButton = -1;

    /**
     * Gets the mouse handler.
     *
     * @return The mouse handler.
     */
    public static MouseHandler getMouse() {
        return ClientUtils.getClient().mouseHandler;
    }

    /**
     * Gets the current mouse position.
     *
     * @return The mouse position as a Vec2 object.
     */
    public static Vec2<Integer> getMousePos() {
        return new Vec2<>((int)Math.round(getMouse().xpos()), (int)Math.round(getMouse().ypos()));
    }

    /**
     * Checks if the specified mouse button is currently pressed.
     *
     * @param button The button to check.
     * @return true if the button is pressed, false otherwise.
     */
    public static boolean isMouseDown(int button) {
        return mouseButton == button;
    }

    /**
     * Sets the specified mouse button as pressed.
     *
     * @param button The button to set as pressed.
     */
    public static void setMouseDown(int button) {
        mouseButton = button;
    }

    /**
     * Sets the mouse button as released.
     */
    public static void setMouseUp() {
        mouseButton = -1;
    }

    /**
     * Checks if the mouse is currently hovering over the specified box.
     *
     * @param box The box to check.
     * @return true if the mouse is hovering over the box, false otherwise.
     */
    public static boolean isMouseHovering(Rect<Integer> box) {
        int boxX = box.getX();
        int boxY = box.getY();
        int boxWidth = box.getWidth();
        int boxHeight = box.getHeight();

        Vec2<Integer> mousePoint = getMousePos();
        int mouseX = mousePoint.getX();
        int mouseY = mousePoint.getY();

        return mouseX >= boxX && mouseX <= boxX + boxWidth &&
                mouseY >= boxY && mouseY <= boxY + boxHeight;
    }
}
