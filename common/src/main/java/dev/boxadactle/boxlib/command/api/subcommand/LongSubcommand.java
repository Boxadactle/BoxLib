package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BArgumentSubcommand;
import dev.boxadactle.boxlib.command.api.CommandExecutor;

public class LongSubcommand extends BArgumentSubcommand<Long> {
    protected String name;
    protected CommandExecutor<Long> executor;

    public LongSubcommand(String name, CommandExecutor<Long> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected ArgumentType<Long> getType() {
        return LongArgumentType.longArg();
    }

    @Override
    protected CommandExecutor<Long> getExecutor() {
        return executor;
    }

    @Override
    protected Long getArgument(CommandContext<BCommandSourceStack> context) {
        return LongArgumentType.getLong(context, getName());
    }
}
