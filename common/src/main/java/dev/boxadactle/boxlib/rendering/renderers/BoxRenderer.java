package dev.boxadactle.boxlib.rendering.renderers;

import dev.boxadactle.boxlib.math.geometry.Box;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.gizmos.GizmoStyle;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.util.debug.DebugValueAccess;
import net.minecraft.world.phys.AABB;

public class BoxRenderer extends Renderer3D<BoxRenderer> {

    AABB box;

    boolean outline = false;

    float outlineWidth = 3.0f;

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

    // im not exactly sure as to why it needs to be multiplied by 2, but whatever
    public BoxRenderer setCube(Box<Double> cube) {
        return setCube(new AABB(cube.minX()*2, cube.minY()*2, cube.minZ()*2, cube.maxX()*2, cube.maxY()*2, cube.maxZ()*2));
    }

    public BoxRenderer setCube(BlockPos pos) {
        return setCube(new AABB(pos.getX()*2, pos.getY()*2, pos.getZ()*2, pos.getX()*2 + 2, pos.getY()*2 + 2, pos.getZ()*2 + 2));
    }

    public BoxRenderer setOutline(boolean outline) {
        this.outline = outline;
        return this;
    }

    public BoxRenderer setOutlineWidth(float outlineWidth) {
        this.outlineWidth = outlineWidth;
        return this;
    }

    @Override
    public void render(double var1, double var3, double var5, DebugValueAccess debugValueAccess, Frustum frustum, float delta) {
        AABB box = this.box.move(getCamera().position().reverse());

        var gizmos = Gizmos.cuboid(box, outline ? GizmoStyle.stroke(rgba, outlineWidth) : GizmoStyle.fill(rgba));

        if (xray) {
            gizmos.setAlwaysOnTop();
        }
    }
}
