package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.context.CommandContext;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

@FunctionalInterface
public interface CommandExecutor<T> {

    int run(CommandContext<BCommandSourceStack> context, T arg);

}
