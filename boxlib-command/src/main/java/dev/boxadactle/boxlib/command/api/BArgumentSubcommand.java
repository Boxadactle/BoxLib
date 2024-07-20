package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

public abstract class BArgumentSubcommand<T> extends BClientSubcommand {

    @Override
    public ArgumentBuilder<BCommandSourceStack, ?> getSubcommand() {
        return BCommandManager.argument(getName(), getType());
    }

    @Override
    protected void build(ArgumentBuilder<BCommandSourceStack, ?> builder) {
        builder.executes(context -> {
            T argument = getArgument(context);

            return getExecutor().run(context, argument);
        });
    }

    protected abstract String getName();

    protected abstract ArgumentType<T> getType();

    protected abstract CommandExecutor<T> getExecutor();

    protected abstract T getArgument(CommandContext<BCommandSourceStack> context);
}
