package dev.boxadactle.boxlib.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.debug.DebugValueAccess;

@SuppressWarnings("unchecked")
public abstract class Renderer3D<T> {

    protected boolean disposeNextFrame;

    protected int rgba;

    protected boolean xray = false;


    public Renderer3D(boolean disposeNextFrame) {
        this.disposeNextFrame = disposeNextFrame;
    }

    public abstract void render(double var1, double var3, double var5, DebugValueAccess debugValueAccess, Frustum frustum, float delta);

    public boolean disposeNextFrame() {
        return disposeNextFrame;
    }

    public T setColor(float r, float g, float b, float a) {
        rgba =
                ((int)(a * 255) << 24) |
                ((int)(b * 255) << 16) |
                ((int)(g * 255) << 8)  |
                ((int)(r * 255));
        return (T) this;
    }


    public T setColor(int rgba) {
        this.rgba = rgba;
        return (T) this;
    }

    public T setXRay(boolean xray) {
        this.xray = xray;
        return (T) this;
    }

    protected Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    protected Camera getCamera() {
        return getMinecraft().gameRenderer.getMainCamera();
    }
}
