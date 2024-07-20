package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class FloatSubcommand extends BArgumentSubcommand<Float> {
    protected String name;
    protected CommandExecutor<Float> executor;

    public FloatSubcommand(String name, CommandExecutor<Float> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<Float> getType() {
        return FloatArgumentType.floatArg();
    }

    @Override
    protected CommandExecutor<Float> getExecutor() {
        return executor;
    }

    @Override
    protected Float getArgument(CommandContext<BCommandSourceStack> context) {
        return FloatArgumentType.getFloat(context, getName());
    }
}
