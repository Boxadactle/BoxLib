package dev.boxadactle.boxlib.test.fabric;

import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ExampleConfigScreen::new;
    }
}
