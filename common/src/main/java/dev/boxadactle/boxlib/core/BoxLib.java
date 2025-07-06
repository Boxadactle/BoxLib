package dev.boxadactle.boxlib.core;

import dev.boxadactle.boxlib.test.TestMod;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;

public class BoxLib {

    public static ModLogger LOGGER = new ModLogger(ModConstants.MOD_NAME);

    public static void init() {
        GuiUtils.init();

        BoxLib.LOGGER.info("Initialized %s", ModConstants.MOD_NAME + " v" + ModConstants.VERSION);

        if (ModConstants.IS_TEST_ENVIRONMENT) TestMod.init();
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
