package dev.boxadactle.boxlib.rendering.renderers;

import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.gizmos.TextGizmo;
import net.minecraft.network.chat.Component;
import net.minecraft.util.debug.DebugValueAccess;

import java.awt.*;

public class TextRenderer extends Renderer3D<TextRenderer> {
    Vec3<Double> pos;
    Component text;
    float size = 0.02F;
    boolean centered = true;
    float offset = 0.0F;
    public TextRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    public TextRenderer setPos(Vec3<Double> pos) {
        this.pos = pos;
        return this;
    }

    public TextRenderer setText(Component text) {
        this.text = text;
        return this;
    }

    public TextRenderer setSize(float size) {
        this.size = size;
        return this;
    }

    public TextRenderer setCentered(boolean centered) {
        this.centered = centered;
        return this;
    }

    /**
     * Sets a vertical offset in pixels. Any value that isn't zero will result in left aligned text
     * @param offset offset in pixels
     * @return this object
     */
    public TextRenderer setOffset(float offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public void render(double var1, double var3, double var5, DebugValueAccess debugValueAccess, Frustum frustum, float delta) {
        var style = TextGizmo.Style.forColor(rgba).withScale(size * 10);
        if (offset != 0.0F) style.withLeftAlignment(offset);
        var gizmos = Gizmos.billboardText(
                text.getString(),
                new net.minecraft.world.phys.Vec3(pos.x, pos.y, pos.z),
                style);

        if (xray) {
            gizmos.setAlwaysOnTop();
        }
    }
}
