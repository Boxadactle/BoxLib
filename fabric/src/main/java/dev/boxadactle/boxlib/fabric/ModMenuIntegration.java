package dev.boxadactle.boxlib.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ModConstants.IS_TEST_ENVIRONMENT ? ExampleConfigScreen::new : ModMenuApi.super.getModConfigScreenFactory();
    }
}
