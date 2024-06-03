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

public class BClientCommand {

    protected String commandName;

    protected Function<CommandContext<BCommandSourceStack>, Integer> rootCommand;

    protected List<BClientSubcommand> subcommands;

    public static BClientCommand create(
            String commandName,
            Function<CommandContext<BCommandSourceStack>, Integer> rootCommand
    ) {
        return new BClientCommand(commandName, rootCommand);
    }

    public static BClientCommand create(
            String commandName
    ) {
        return new BClientCommand(commandName, (context) -> 0);
    }

    protected BClientCommand(
            String commandName,
            Function<CommandContext<BCommandSourceStack>, Integer> rootCommand
    ) {
        this.commandName = commandName;
        this.rootCommand = rootCommand;
        this.subcommands = new ArrayList<>();
    }

    public void register(CommandDispatcher<BCommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<BCommandSourceStack> root = BCommandManager.literal(commandName)
                .executes(rootCommand::apply);

        for (BClientSubcommand subcommand : subcommands) {
            root.then(subcommand.buildSubcommand());
        }

        dispatcher.register(root);
    }

    public BClientCommand registerSubcommand(BClientSubcommand subcommand) {
        subcommands.add(subcommand);

        return this;
    }

    public BClientCommand registerSubcommand(String name, Function<CommandContext<BCommandSourceStack>, Integer> executor) {
        BClientSubcommand command = new BClientSubcommand() {
            @Override
            public ArgumentBuilder<BCommandSourceStack, ?> getSubcommand() {
                return BCommandManager.literal(name);
            }

            @Override
            public void build(ArgumentBuilder<BCommandSourceStack, ?> builder) {
                builder.executes(executor::apply);
            }
        };

        return registerSubcommand(command);
    }

}
