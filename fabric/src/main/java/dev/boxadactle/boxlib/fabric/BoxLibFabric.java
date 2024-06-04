package dev.boxadactle.boxlib.fabric;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.BCommandImpl;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.keybind.KeybindHelper;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BoxLibFabric implements ClientModInitializer {

    @Override
    @SuppressWarnings("unchecked")
    public void onInitializeClient() {
        BoxLib.init();

        KeybindingImpl.register(KeybindHelper::registerKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Scheduling.tick();
        });

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            BCommandImpl.register((CommandDispatcher<BCommandSourceStack>) (CommandDispatcher<?>) dispatcher);
        });
    }

}