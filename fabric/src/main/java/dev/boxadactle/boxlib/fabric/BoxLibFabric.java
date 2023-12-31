package dev.boxadactle.boxlib.fabric;

import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.fabric.command.BCommandManager;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BoxLibFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BoxLib.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Scheduling.tick();
        });

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            BCommandManager.registerToGame(dispatcher);
        });
    }

}