package dev.boxadactle.boxlib.test;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.test.command.FunnyClientCommand;
import dev.boxadactle.boxlib.test.config.ExampleConfigClass;
import dev.boxadactle.boxlib.util.ModLogger;

public class TestMod {

    public static final String MOD_NAME = "Boxlib Test Mod";

    public static final String MOD_ID = "boxlib-testmod";

    public static final ModLogger LOGGER = new ModLogger(MOD_NAME);

    public static BConfigClass<ExampleConfigClass> CONFIG;

    public static void init() {
        LOGGER.info("Initializing " + MOD_NAME + "...");

        // make sure to register your config class like this
        CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

        // make sure to register your client commands like this
        BCommandManager.register(FunnyClientCommand.create());
    }

}
