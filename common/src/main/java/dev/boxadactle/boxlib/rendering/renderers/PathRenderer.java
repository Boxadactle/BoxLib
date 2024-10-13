package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class PathRenderer extends Renderer3D<PathRenderer> {
    Vec3<Double>[] points;

    public PathRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    @SafeVarargs
    public final PathRenderer setPoints(Vec3<Double>... points) {
        this.points = points;
        return this;
    }

    @Override
    protected void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.debugLineStrip(1.0));

        for (Vec3<Double> d : points) {
            vertexConsumer
                    .addVertex(stack.last(), (float) (d.x - cameraX), (float) (d.y - cameraY), (float) (d.z - cameraZ))
                    .setColor(r, g, b, a);
        }
    }
}
