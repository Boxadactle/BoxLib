package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.ArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BSubcommand;

public class BasicSubcommand extends BSubcommand {
    String name;

    Command<BCommandSourceStack> executor;

    public BasicSubcommand(String name, Command<BCommandSourceStack> executor) {
        this.name = name;
        this.executor = executor;
    }

    @Override
    public ArgumentBuilder<BCommandSourceStack, ?> getSubcommand() {
        return BCommandManager.literal(name);
    }

    @Override
    protected void build(ArgumentBuilder<BCommandSourceStack, ?> builder) {
        builder.executes(executor);
    }
}
