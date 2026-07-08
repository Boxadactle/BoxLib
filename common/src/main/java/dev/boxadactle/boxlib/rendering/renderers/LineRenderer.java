package dev.boxadactle.boxlib.rendering.renderers;

import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.util.debug.DebugValueAccess;

public class LineRenderer extends Renderer3D<LineRenderer> {
    Vec3<Double> start;
    Vec3<Double> end;

    float width = 3.0F;

    public LineRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    public LineRenderer setStart(Vec3<Double> start) {
        this.start = start;
        return this;
    }

    public LineRenderer setEnd(Vec3<Double> end) {
        this.end = end;
        return this;
    }

    public LineRenderer setPos(Vec3<Double> start, Vec3<Double> end) {
        this.start = start;
        this.end = end;
        return this;
    }

    public LineRenderer setPos(double startX, double startY, double startZ, double endX, double endY, double endZ) {
        return setPos(new Vec3<>(startX, startY, startZ), new Vec3<>(endX, endY, endZ));
    }

    public LineRenderer setWidth(float width) {
        this.width = width;
        return this;
    }

    @Override
    public void render(double var1, double var3, double var5, DebugValueAccess debugValueAccess, Frustum frustum, float delta) {
        var gizmos = Gizmos.line(
                new net.minecraft.world.phys.Vec3(start.x, start.y, start.z),
                new net.minecraft.world.phys.Vec3(end.x, end.y, end.z),
                rgba,
                width
        );

        if (xray) {
            gizmos.setAlwaysOnTop();
        }
    }
}
