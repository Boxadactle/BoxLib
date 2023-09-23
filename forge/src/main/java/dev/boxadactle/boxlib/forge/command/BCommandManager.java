package dev.boxadactle.boxlib.forge.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.function.ClassProvider;
import net.minecraft.commands.CommandSourceStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BCommandManager {

    static HashMap<String, List<ClassProvider<BClientCommand>>> commands = new HashMap<>();

    public static void registerCommand(String command, CommandRegister callback) {

        commands.put(command, new ArrayList<>());

        callback.registerSubcommands(commands.get(command));

    }

    public static void registerToGame(CommandDispatcher<CommandSourceStack> dispatcher) {

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
