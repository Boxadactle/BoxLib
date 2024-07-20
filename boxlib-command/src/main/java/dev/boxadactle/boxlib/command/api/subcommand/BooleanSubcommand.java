package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class BooleanSubcommand extends BArgumentSubcommand<Boolean> {
    protected String name;
    protected CommandExecutor<Boolean> executor;

    public BooleanSubcommand(String name, CommandExecutor<Boolean> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<Boolean> getType() {
        return BoolArgumentType.bool();
    }

    @Override
    protected CommandExecutor<Boolean> getExecutor() {
        return executor;
    }

    @Override
    protected Boolean getArgument(CommandContext<BCommandSourceStack> context) {
        return BoolArgumentType.getBool(context, getName());
    }
}
