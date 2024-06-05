package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

/**
 * This interface represents a client subcommand in the BoxLib command system.
 * A client subcommand is a subcommand that can be executed by a client.
 */
public interface BClientSubcommand {

    /**
     * Gets the subcommand as an ArgumentBuilder.
     *
     * @return the subcommand as an ArgumentBuilder
     */
    ArgumentBuilder<BCommandSourceStack, ?> getSubcommand();

    /**
     * Builds the subcommand using the provided ArgumentBuilder.
     *
     * @param builder the ArgumentBuilder to build the subcommand with
     */
    void build(ArgumentBuilder<BCommandSourceStack, ?> builder);

    /**
     * Builds and returns the subcommand as an ArgumentBuilder.
     *
     * @return the built subcommand as an ArgumentBuilder
     */
    default ArgumentBuilder<BCommandSourceStack, ?> buildSubcommand() {
        ArgumentBuilder<BCommandSourceStack, ?> builder = this.getSubcommand();
        this.build(builder);

        return builder;
    }

}
