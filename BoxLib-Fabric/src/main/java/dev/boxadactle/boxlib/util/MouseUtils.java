package dev.boxadactle.boxlib.util;

import dev.boxadactle.boxlib.math.Rect;
import dev.boxadactle.boxlib.math.Vec2;
import net.minecraft.client.Mouse;

public class MouseUtils {

    static int mouseButton = -1;

    public static Mouse getMouse() {
        return ClientUtils.getClient().mouse;
    }

    public static Vec2<Integer> getMousePos() {
        return new Vec2<>((int)Math.round(getMouse().getX()), (int)Math.round(getMouse().getY()));
    }

    public static boolean isMouseDown(int button) {
        return mouseButton == button;
    }

    public static void setMouseDown(int button) {
        mouseButton = button;
    }

    public static void setMouseUp() {
        mouseButton = -1;
    }

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
