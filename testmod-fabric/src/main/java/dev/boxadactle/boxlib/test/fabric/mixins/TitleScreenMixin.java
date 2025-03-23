package dev.boxadactle.boxlib.test.fabric.mixins;

import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import dev.boxadactle.boxlib.util.ClientUtils;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Component component) {
        super(component);
    }

    @Inject(at = @At("RETURN"), method = "init()V")
    private void init(CallbackInfo info) {
        addButton(new Button(0, 0, 90, 20, new TranslatableComponent("menu.options"), (button) -> {
            ClientUtils.setScreen(new ExampleConfigScreen(this));
        }));
    }

}
