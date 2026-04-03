package dev.boxadactle.boxlib.fabric.mixin;

import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void onInit(CallbackInfo ci) {
        if (ModConstants.IS_DEVELOPMENT) {
            addRenderableWidget(Button.builder(Component.literal("Open Config"), button -> {
                ClientUtils.setScreen(new ExampleConfigScreen(this));
            }).bounds(5, 5, 200, 20).build());
        }
    }
}
