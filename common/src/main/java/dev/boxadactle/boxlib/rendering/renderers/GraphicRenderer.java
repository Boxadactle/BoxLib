package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;

public class GraphicRenderer extends Renderer3D<GraphicRenderer> {
    Vec3<Double> pos;
    Renderer renderer;
    float size = 0.1F;

    int width;
    int height;
    boolean centered;

    public GraphicRenderer(boolean disposeNextFrame) {
        super(disposeNextFrame);
    }

    public GraphicRenderer setRenderer(Renderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public GraphicRenderer setPos(Vec3<Double> pos) {
        this.pos = pos;
        return this;
    }

    public GraphicRenderer setSize(float size) {
        this.size = size;
        return this;
    }

    public GraphicRenderer setWidth(int width) {
        this.width = width;
        return this;
    }

    public GraphicRenderer setHeight(int height) {
        this.height = height;
        return this;
    }

    public GraphicRenderer setCentered(boolean centered) {
        this.centered = centered;
        return this;
    }

    @Override
    public void render(PoseStack ignored, MultiBufferSource.BufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        GuiGraphics graphics = new GuiGraphics(Minecraft.getInstance(), buffer);

        PoseStack stack = graphics.pose();
        stack.pushPose();
        stack.translate((float)(pos.x - cameraX), (float)(pos.y - cameraY) + 0.07F, (float)(pos.z - cameraZ));
        stack.mulPose(Minecraft.getInstance().gameRenderer.getMainCamera().rotation());
        stack.scale(size, -size, size);

        if (centered && (width == 0 || height == 0)) {
            throw new IllegalStateException("Width and height must be set when centered is true");
        }

        renderer.render(graphics, centered ? -width / 2 : 0, centered ? -height / 2 : 0);

        stack.popPose();
    }

    @FunctionalInterface
    public interface Renderer {
        void render(GuiGraphics graphics, int x, int y);
    }
}
