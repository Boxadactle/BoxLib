package dev.boxadactle.boxlib.test.fabric;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import io.github.prospector.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Function;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return ExampleConfigScreen::new;
    }

    @Override
    public String getModId() {
        return TestMod.MOD_ID;
    }
}
