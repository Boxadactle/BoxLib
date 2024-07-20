package dev.boxadactle.boxlib.command.api.subcommand;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.ArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BClientSubcommand;

public class BLabelSubcommand extends BClientSubcommand {
    String name;
    Command<BCommandSourceStack> executor;

    public BLabelSubcommand(String name, Command<BCommandSourceStack> executor, BClientSubcommand sub) {
        this.name = name;
        this.executor = executor;

        registerSubcommand(sub);
    }

    public BLabelSubcommand(String name, BClientSubcommand sub) {
        this(name, null, sub);
    }

    @Override
    protected ArgumentBuilder<BCommandSourceStack, ?> getSubcommand() {
        return BCommandManager.literal(name);
    }

    @Override
    protected void build(ArgumentBuilder<BCommandSourceStack, ?> builder) {
        if (executor != null) {
            builder.executes(executor);
        }
    }
}
