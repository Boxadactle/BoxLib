package dev.boxadactle.boxlib.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;

@SuppressWarnings("unchecked")
public abstract class Renderer3D<T> {

    protected boolean disposeNextFrame;

    protected float r;
    protected float g;
    protected float b;
    protected float a;


    public Renderer3D(boolean disposeNextFrame) {
        this.disposeNextFrame = disposeNextFrame;
    }

    protected abstract void render(PoseStack stack, MultiBufferSource buffer, double cameraX, double cameraY, double cameraZ);

    public boolean disposeNextFrame() {
        return disposeNextFrame;
    }

    public T setColor(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        return (T) this;
    }

    public T setColor(float r, float g, float b) {
        return setColor(r, g, b, 1.0F);
    }

    public T setColor(int rgb) {
        return setColor((rgb >> 16 & 0xFF) / 255.0F, (rgb >> 8 & 0xFF) / 255.0F, (rgb & 0xFF) / 255.0F, 1.0F);
    }

    public T setRed(float r) {
        this.r = r;
        return (T) this;
    }

    public T setGreen(float g) {
        this.g = g;
        return (T) this;
    }

    public T setBlue(float b) {
        this.b = b;
        return (T) this;
    }

    public T setAlpha(float a) {
        this.a = a;
        return (T) this;
    }

    protected Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }

    protected Camera getCamera() {
        return getMinecraft().gameRenderer.getMainCamera();
    }
}
