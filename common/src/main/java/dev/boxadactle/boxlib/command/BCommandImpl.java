package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.api.BCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * The BCommandImpl class represents the implementation of a command manager for BoxLib.
 * It provides methods to add and register client commands.
 */
public class BCommandImpl {

    static List<BCommand> commands = new ArrayList<>();

    /**
     * Adds a client command to the command manager.
     *
     * @param command The client command to add.
     */
    public static void addCommand(BCommand command) {
        commands.add(command);
    }

    /**
     * Registers all the added client commands with the given command dispatcher.
     *
     * @param dispatcher The command dispatcher to register the commands with.
     */
    public static void register(CommandDispatcher<BCommandSourceStack> dispatcher) {
        commands.forEach(command -> command.register(dispatcher));
    }

}
