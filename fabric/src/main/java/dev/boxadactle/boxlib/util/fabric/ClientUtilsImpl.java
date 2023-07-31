package dev.boxadactle.boxlib.util.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class ClientUtilsImpl {

    public static Path getConfigFolder() {
        return FabricLoader.getInstance().getConfigDir();
    }

}
