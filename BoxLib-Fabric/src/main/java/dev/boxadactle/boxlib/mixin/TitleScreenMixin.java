package dev.boxadactle.boxlib.mixin;

import dev.boxadactle.boxlib.BoxLib;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void stupid(CallbackInfo ci) {

        if (BoxLib.DEBUG_MODE) this.addDrawableChild(new ButtonWidget.Builder(Text.literal("stupid"), b -> ClientUtils.setScreen(new BoxLib.DebugConfigScreen(this))).dimensions(2, 2, 50, 20).build());
    }
}
