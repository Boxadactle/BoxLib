package dev.boxadactle.boxlib.base;

import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.RenderUtils;

public class BoxLib {

    public static ModLogger LOGGER = new ModLogger(ModConstants.MOD_NAME);

    public static void init() {
        GuiUtils.init();
        RenderUtils.init();
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
