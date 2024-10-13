package dev.boxadactle.boxlib.neoforge.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.rendering.RenderImpl;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.debug.DebugRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugRenderer.class)
public class DebugRendererMixin {

    @Inject(method = "render", at = @At("RETURN"))
    public void render3D(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, double d, double e, double f, CallbackInfo ci) {
        RenderImpl.renderAll(poseStack, bufferSource, d, e, f);
    }

}
