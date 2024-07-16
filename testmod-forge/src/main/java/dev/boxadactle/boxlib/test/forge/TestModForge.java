package dev.boxadactle.boxlib.test.forge;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmlclient.ConfigGuiHandler;

@Mod(TestMod.MOD_ID)
public class TestModForge {

    public TestModForge() {
        TestMod.init();

        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory(((minecraft, screen) -> new ExampleConfigScreen(screen)))
        );
    }

}