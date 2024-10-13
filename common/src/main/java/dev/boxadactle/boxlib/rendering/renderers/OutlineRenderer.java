package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.math.geometry.Box;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

public class OutlineRenderer extends Renderer3D<OutlineRenderer> {
    private LineRenderer[] edges = new LineRenderer[12];

    public OutlineRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    private LineRenderer edge(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new LineRenderer(false).setPos(x1, y1, z1, x2, y2, z2);
    }

    public OutlineRenderer setCube(AABB cube) {
        edges[0] = edge(cube.minX, cube.minY, cube.minZ, cube.maxX, cube.minY, cube.minZ);
        edges[1] = edge(cube.minX, cube.minY, cube.minZ, cube.minX, cube.maxY, cube.minZ);
        edges[2] = edge(cube.minX, cube.minY, cube.minZ, cube.minX, cube.minY, cube.maxZ);
        edges[3] = edge(cube.maxX, cube.minY, cube.maxX, cube.maxX, cube.minY, cube.minZ);
        edges[4] = edge(cube.maxX, cube.minY, cube.maxX, cube.maxX, cube.maxY, cube.maxZ);
        edges[5] = edge(cube.maxX, cube.minY, cube.maxX, cube.minX, cube.minY, cube.maxZ);
        edges[6] = edge(cube.maxX, cube.maxY, cube.minZ, cube.maxX, cube.minY, cube.minZ);
        edges[7] = edge(cube.maxX, cube.maxY, cube.minZ, cube.minX, cube.maxY, cube.minZ);
        edges[8] = edge(cube.maxX, cube.maxY, cube.minZ, cube.maxX, cube.maxY, cube.maxZ);
        edges[9] = edge(cube.minX, cube.maxY, cube.maxZ, cube.minX, cube.minY, cube.maxZ);
        edges[10] = edge(cube.minX, cube.maxY, cube.maxZ, cube.minX, cube.maxY, cube.minZ);
        edges[11] = edge(cube.minX, cube.maxY, cube.maxZ, cube.maxX, cube.maxY, cube.maxZ);

        return this;
    }

    public OutlineRenderer setCube(AABB cube, double expand) {
        AABB inflated = cube.inflate(expand);
        return setCube(inflated);
    }

    public OutlineRenderer setCube(Box<Double> cube) {
        return setCube(new AABB(cube.minX(), cube.minY(), cube.minZ(), cube.maxX(), cube.maxY(), cube.maxZ()));
    }

    public OutlineRenderer setCube(BlockPos pos) {
        return setCube(new AABB(pos));
    }

    @Override
    protected void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        for (LineRenderer edge : edges) {
            edge.setColor(r, g, b, a);
            edge.render(stack, buffer, cameraX, cameraY, cameraZ);
        }
    }
}
