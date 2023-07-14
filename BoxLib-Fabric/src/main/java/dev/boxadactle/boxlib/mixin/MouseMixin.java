package dev.boxadactle.boxlib.mixin;

import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {

    @Shadow private int activeButton;

    @Inject(at = @At("RETURN"), method = "onMouseButton")
    private void mouseButton(long window, int button, int action, int mods, CallbackInfo ci) {
        if (this.activeButton != -1)
            MouseUtils.setMouseDown(this.activeButton);
        else
            MouseUtils.setMouseUp();
    }

}
