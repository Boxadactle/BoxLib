package dev.boxadactle.boxlib.fabric.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.function.ClassProvider;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Deprecated(forRemoval = true, since = "13.1.0")
public class BCommandManager {

    static HashMap<String, List<ClassProvider<BClientCommand>>> commands = new HashMap<>();

    public static void registerCommand(String command, CommandRegister callback) {

        commands.put(command, new ArrayList<>());

        callback.registerSubcommands(commands.get(command));

    }

    public static void registerToGame(CommandDispatcher<FabricClientCommandSource> dispatcher) {

        commands.forEach((command, list) -> {
            list.forEach(provider -> {
                provider.get().register(dispatcher);
            });
        });

    }

    @FunctionalInterface
    public interface CommandRegister {
        void registerSubcommands(List<ClassProvider<BClientCommand>> list);
    }

}