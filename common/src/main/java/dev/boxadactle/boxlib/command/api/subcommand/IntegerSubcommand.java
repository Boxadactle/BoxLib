package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class IntegerSubcommand extends BArgumentSubcommand<Integer> {
    protected String name;
    protected CommandExecutor<Integer> executor;

    public IntegerSubcommand(String name, CommandExecutor<Integer> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<Integer> getType() {
        return IntegerArgumentType.integer();
    }

    @Override
    protected CommandExecutor<Integer> getExecutor() {
        return executor;
    }

    @Override
    protected Integer getArgument(CommandContext<BCommandSourceStack> context) {
        return IntegerArgumentType.getInteger(context, getName());
    }
}
