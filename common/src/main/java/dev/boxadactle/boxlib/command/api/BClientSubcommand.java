package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

public interface BClientSubcommand {

    ArgumentBuilder<BCommandSourceStack, ?> getSubcommand();

    void build(ArgumentBuilder<BCommandSourceStack, ?> builder);

    default ArgumentBuilder<BCommandSourceStack, ?> buildSubcommand() {
        ArgumentBuilder<BCommandSourceStack, ?> builder = this.getSubcommand();
        this.build(builder);

        return builder;
    }

}
