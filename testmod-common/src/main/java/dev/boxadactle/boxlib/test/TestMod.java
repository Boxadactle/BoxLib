package dev.boxadactle.boxlib.test;

import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.keybind.KeybindHelper;
import dev.boxadactle.boxlib.test.config.ExampleConfigClass;
import dev.boxadactle.boxlib.test.keybind.Keybindings;
import dev.boxadactle.boxlib.translate.Language;
import dev.boxadactle.boxlib.translate.Translator;
import dev.boxadactle.boxlib.util.ModLogger;

public class TestMod {

    public static final String MOD_NAME = "Boxlib Test Mod";

    public static final String MOD_ID = "boxlibtestmod";

    public static final ModLogger LOGGER = new ModLogger(MOD_NAME);

    public static BConfigClass<ExampleConfigClass> CONFIG;

    public static void init() {
        LOGGER.info("Initializing " + MOD_NAME + "...");

        // make sure to register your config class like this
        CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

        Keybindings.init();

        String message = "Test keybind 1 is bound to " + KeybindHelper.getBoundKey(Keybindings.TEST_KEYBIND);

        // you can use google translate to translate messages
        String translated = Translator.translate(message, Language.SPANISH);
        LOGGER.info(translated);
    }

}
