package dev.boxadactle.boxlib.rendering.renderers;

import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.util.debug.DebugValueAccess;

public class PathRenderer extends Renderer3D<PathRenderer> {
    Vec3<Double>[] points;

    float width = 3.0F;

    public PathRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    @SafeVarargs
    public final PathRenderer setPoints(Vec3<Double>... points) {
        this.points = points;
        return this;
    }

    public PathRenderer setWidth(float width) {
        this.width = width;
        return this;
    }

    @Override
    public void render(double var1, double var3, double var5, DebugValueAccess debugValueAccess, Frustum frustum, float delta) {
        for (int i = 1; i < points.length; i++) {
            var gizmos = Gizmos.line(
                    new net.minecraft.world.phys.Vec3(points[i - 1].x, points[i - 1].y, points[i - 1].z),
                    new net.minecraft.world.phys.Vec3(points[i].x, points[i].y, points[i].z),
                    rgba,
                    width
            );

            if (xray) {
                gizmos.setAlwaysOnTop();
            }

        }
    }
}
