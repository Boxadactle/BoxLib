package dev.boxadactle.boxlib.test.neoforge;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod(TestMod.MOD_ID)
public class TestModNeoForge {

    public TestModNeoForge() {
        TestMod.init();

        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory(((minecraft, screen) -> new ExampleConfigScreen(screen)))
        );
    }

}
