package dev.boxadactle.boxlib.test.neoforge;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(TestMod.MOD_ID)
public class TestModNeoForge {

    public TestModNeoForge() {
        System.out.println(Minecraft.getInstance());
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (minecraft, screen) -> new ExampleConfigScreen(screen)
        );
    }

    @EventBusSubscriber(modid = TestMod.MOD_ID)
    public static class Skibidi {
        @SubscribeEvent
        public static void init(FMLClientSetupEvent e) {
            TestMod.init();
        }
    }

}
