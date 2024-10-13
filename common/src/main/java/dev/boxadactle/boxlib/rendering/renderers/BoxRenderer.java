package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.boxadactle.boxlib.math.geometry.Box;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

public class BoxRenderer extends Renderer3D<BoxRenderer> {

    AABB box;

    public BoxRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    public BoxRenderer setCube(AABB cube) {
        this.box = cube;
        return this;
    }

    public BoxRenderer setCube(AABB cube, double expand) {
        AABB inflated = cube.inflate(expand);
        return setCube(inflated);
    }

    public BoxRenderer setCube(Box<Double> cube) {
        return setCube(new AABB(cube.minX(), cube.minY(), cube.minZ(), cube.maxX(), cube.maxY(), cube.maxZ()));
    }

    public BoxRenderer setCube(BlockPos pos) {
        return setCube(new AABB(pos));
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        VertexConsumer consumer = buffer.getBuffer(RenderType.debugFilledBox());

        AABB box = this.box.move(getCamera().getPosition().reverse());

        Matrix4f matrix = stack.last().pose();
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.minY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.minX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.minZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
        consumer.addVertex(matrix, (float) box.maxX, (float) box.maxY, (float) box.maxZ).setColor(r, g, b, a);
    }
}
