package dev.boxadactle.boxlib.mixin;

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

    @Inject(method = "init", at = @At("RETURN"))
    public void addTestButton(CallbackInfo ci) {
        addWidget(Button.builder(Component.literal("testing screen"), b -> ClientUtils.setScreen(new ExampleConfigScreen(this))).bounds(0, 0, 50, 20).build());
    }
}
