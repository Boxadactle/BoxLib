package dev.boxadactle.boxlib.util.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ClientUtilsImpl {

    public static Path getConfigFolder() {
        return FMLPaths.CONFIGDIR.get();
    }

}
