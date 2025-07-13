package dev.boxadactle.boxlib.test.fabric;

import dev.boxadactle.boxlib.test.TestMod;
import net.fabricmc.api.ClientModInitializer;

public class TestModFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TestMod.init();
    }
}
