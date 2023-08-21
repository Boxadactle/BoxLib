package dev.boxadactle.boxlib.fabric;

import dev.boxadactle.boxlib.BoxLibInitializer;
import dev.boxadactle.boxlib.command.fabric.BCommandManager;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BoxLibFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BoxLibInitializer.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Scheduling.tick();
        });

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            BCommandManager.registerToGame(dispatcher);
        });
    }

}