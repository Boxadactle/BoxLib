package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The BClientCommand class represents a client-side command in the BoxLib mod.
 * It provides methods to create and register subcommands for the command.
 */
public class BClientCommand {

    protected String commandName;

    protected Function<CommandContext<BCommandSourceStack>, Integer> rootCommand;

    protected List<BClientSubcommand> subcommands;

    /**
     * Creates a new BClientCommand with the specified command name and root command.
     *
     * @param commandName  the name of the command
     * @param rootCommand  the root command to be executed when the command is invoked
     * @return a new BClientCommand instance
     */
    public static BClientCommand create(
            String commandName,
            Function<CommandContext<BCommandSourceStack>, Integer> rootCommand
    ) {
        return new BClientCommand(commandName, rootCommand);
    }

    /**
     * Creates a new BClientCommand with the specified command name and a default root command.
     * The default root command does nothing and returns 0.
     *
     * @param commandName  the name of the command
     * @return a new BClientCommand instance
     */
    public static BClientCommand create(
            String commandName
    ) {
        return new BClientCommand(commandName, (context) -> 0);
    }

    /**
     * Constructs a BClientCommand with the specified command name and root command.
     *
     * @param commandName  the name of the command
     * @param rootCommand  the root command to be executed when the command is invoked
     */
    protected BClientCommand(
            String commandName,
            Function<CommandContext<BCommandSourceStack>, Integer> rootCommand
    ) {
        this.commandName = commandName;
        this.rootCommand = rootCommand;
        this.subcommands = new ArrayList<>();
    }

    /**
     * Registers the BClientCommand with the specified command dispatcher.
     *
     * @param dispatcher  the command dispatcher to register the command with
     */
    public void register(CommandDispatcher<BCommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<BCommandSourceStack> root = BCommandManager.literal(commandName)
                .executes(rootCommand::apply);

        for (BClientSubcommand subcommand : subcommands) {
            root.then(subcommand.buildSubcommand());
        }

        dispatcher.register(root);
    }

    /**
     * Registers a subcommand for the BClientCommand.
     *
     * @param subcommand  the subcommand to register
     * @return the BClientCommand instance
     */
    public BClientCommand registerSubcommand(BClientSubcommand subcommand) {
        subcommands.add(subcommand);

        return this;
    }

}
