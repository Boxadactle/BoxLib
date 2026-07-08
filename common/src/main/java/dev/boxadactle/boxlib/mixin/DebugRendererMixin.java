package dev.boxadactle.boxlib.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.boxadactle.boxlib.rendering.RenderImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.util.debug.DebugValueAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugRenderer.class)
public class DebugRendererMixin {
    @Inject(method = "emitGizmos", at = @At("RETURN"))
    public void render3D(Frustum p_456065_, double p_455789_, double p_454848_, double p_456243_, float p_455292_, CallbackInfo ci, @Local DebugValueAccess debugvalueaccess) {
        RenderImpl.renderAll(p_455789_, p_454848_, p_456243_, debugvalueaccess, p_456065_, p_455292_);
    }
}
