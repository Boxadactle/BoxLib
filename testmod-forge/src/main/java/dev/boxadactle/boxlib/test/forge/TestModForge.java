package dev.boxadactle.boxlib.test.forge;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(TestMod.MOD_ID)
public class TestModForge {

    public TestModForge() {
        TestMod.init();

        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () ->
                (minecraft, screen) -> new ExampleConfigScreen(screen)
        );
    }

}