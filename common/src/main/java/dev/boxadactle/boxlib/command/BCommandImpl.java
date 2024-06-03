package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.api.BClientCommand;

import java.util.ArrayList;
import java.util.List;

public class BCommandImpl {

    static List<BClientCommand> commands = new ArrayList<>();

    public static void addCommand(BClientCommand list) {
        commands.add(list);
    }

    public static void register(CommandDispatcher<BCommandSourceStack> dispatcher) {
        commands.forEach(command -> command.register(dispatcher));
    }

}
