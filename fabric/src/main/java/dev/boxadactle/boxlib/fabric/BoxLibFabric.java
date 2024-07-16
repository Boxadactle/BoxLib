package dev.boxadactle.boxlib.fabric;

import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class BoxLibFabric implements ClientModInitializer {

    @Override
    @SuppressWarnings("unchecked")
    public void onInitializeClient() {
        BoxLib.init();

        KeybindingImpl.register(KeyBindingHelper::registerKeyBinding);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Scheduling.tick();
        });

//        BCommandImpl.register((CommandDispatcher<BCommandSourceStack>) (CommandDispatcher<?>) ClientCommandManager.DISPATCHER);
    }

}