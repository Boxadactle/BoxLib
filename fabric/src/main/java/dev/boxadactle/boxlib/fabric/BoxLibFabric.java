package dev.boxadactle.boxlib.fabric;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.BCommandImpl;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;

public class BoxLibFabric implements ClientModInitializer {

    @Override
    @SuppressWarnings("unchecked")
    public void onInitializeClient() {
        BoxLib.init();

        KeybindingImpl.register(KeyBindingHelper::registerKeyBinding);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Scheduling.tick();
        });

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            BCommandImpl.register((CommandDispatcher<BCommandSourceStack>) (CommandDispatcher<?>) dispatcher);
        });

        ModConstants.IS_DEVELOPMENT = FabricLoader.getInstance().isDevelopmentEnvironment();
    }

}