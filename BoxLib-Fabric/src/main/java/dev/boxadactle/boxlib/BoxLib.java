package dev.boxadactle.boxlib;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.example.ExampleConfigClass;
import dev.boxadactle.boxlib.example.ExampleConfigScreen;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class BoxLib implements ClientModInitializer {

    public static ModLogger LOGGER;

    public static final boolean DEBUG_MODE = true;

    public static BConfigClass<ExampleConfigClass> CONFIG;

    @Override
    public void onInitializeClient() {
        LOGGER = new ModLogger(ModConstants.MOD_NAME);

        GuiUtils.init();
        RenderUtils.init();

        // make sure to register your config like this
        CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

        LOGGER.info("Initialized " + ModConstants.MOD_NAME + " v" + ModConstants.VERSION);

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> BCommandManager.registerToGame(dispatcher));
    }

    public static <T> T initializeClass(Class<T> tClass) {
        T a;
        try {
            a = tClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return a;
    }
}
