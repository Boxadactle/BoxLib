package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class GreedyStringSubcommand extends BArgumentSubcommand<String> {
    protected String name;
    protected CommandExecutor<String> executor;

    public GreedyStringSubcommand(String name, CommandExecutor<String> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<String> getType() {
        return StringArgumentType.greedyString();
    }

    @Override
    protected CommandExecutor<String> getExecutor() {
        return executor;
    }

    @Override
    protected String getArgument(CommandContext<BCommandSourceStack> context) {
        return StringArgumentType.getString(context, getName());
    }
}
