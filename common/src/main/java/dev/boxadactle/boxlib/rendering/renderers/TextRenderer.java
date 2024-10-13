package dev.boxadactle.boxlib.rendering.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.Renderer3D;
import dev.boxadactle.boxlib.util.ClientUtils;
import dev.boxadactle.boxlib.util.GuiUtils;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class TextRenderer extends Renderer3D<TextRenderer> {
    Vec3<Double> pos;
    Component text;
    float size = 0.02F;
    boolean centered = true;
    float offset = 0.0F;
    boolean xray = false;
    boolean shadow = false;

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

    public TextRenderer setOffset(float offset) {
        this.offset = offset;
        return this;
    }

    public TextRenderer setXray(boolean xray) {
        this.xray = xray;
        return this;
    }

    public TextRenderer setShadow(boolean shadow) {
        this.shadow = shadow;
        return this;
    }

    private int getColor() {
        return new Color(r, g, b).getRGB();
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ) {
        Camera camera = getCamera();
        if (camera.isInitialized()) {
            stack.pushPose();
            stack.translate((float)(pos.x - cameraX), (float)(pos.y - cameraY) + 0.07F, (float)(pos.z - cameraZ));
            stack.mulPose(camera.rotation());
            stack.scale(size, -size, size);

            float f = centered ? (float)(-GuiUtils.getTextSize(text)) / 2.0F : 0.0F;
            f -= offset / size;

            ClientUtils.getClient().font.drawInBatch(text, f, 0.0F, getColor(), shadow, stack.last().pose(), buffer, xray ? Font.DisplayMode.SEE_THROUGH : Font.DisplayMode.NORMAL, 0, 15728880);

            stack.popPose();
        }
    }
}
