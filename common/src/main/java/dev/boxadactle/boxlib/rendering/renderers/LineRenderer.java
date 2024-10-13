package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

public class LineRenderer extends Renderer3D<LineRenderer> {
    Vec3<Double> start;
    Vec3<Double> end;
    float r;
    float g;
    float b;
    float a;

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

    public LineRenderer setColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        return this;
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.debugLineStrip(1.0));

        vertexConsumer
                .addVertex(stack.last(), (float) (start.x - cameraX), (float) (start.y - cameraY), (float) (start.z - cameraZ))
                .setColor(r, g, b, a);

        vertexConsumer
                .addVertex(stack.last(), (float) (end.x - cameraX), (float) (end.y - cameraY), (float) (end.z - cameraZ))
                .setColor(r, g, b, a);
    }
}
