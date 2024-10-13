package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class DoubleSubcommand extends BArgumentSubcommand<Double> {
    protected String name;
    protected CommandExecutor<Double> executor;

    public DoubleSubcommand(String name, CommandExecutor<Double> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<Double> getType() {
        return DoubleArgumentType.doubleArg();
    }

    @Override
    protected CommandExecutor<Double> getExecutor() {
        return executor;
    }

    @Override
    protected Double getArgument(CommandContext<BCommandSourceStack> context) {
        return DoubleArgumentType.getDouble(context, getName());
    }
}
