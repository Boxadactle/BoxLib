package dev.boxadactle.boxlib.command.api;

import com.mojang.brigadier.builder.ArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandSourceStack;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface represents a client subcommand in the BoxLib command system.
 * A client subcommand is a subcommand that can be executed by a client.
 */
public abstract class BSubcommand {

    protected List<BSubcommand> subcommands;

    protected BSubcommand() {
        subcommands = new ArrayList<>();
    }

    /**
     * Gets the subcommand as an ArgumentBuilder.
     *
     * @return the subcommand as an ArgumentBuilder
     */
    protected abstract ArgumentBuilder<BCommandSourceStack, ?> getSubcommand();

    /**
     * Builds the subcommand using the provided ArgumentBuilder.
     *
     * @param builder the ArgumentBuilder to build the subcommand with
     */
    protected abstract void build(ArgumentBuilder<BCommandSourceStack, ?> builder);

    /**
     * Builds and returns the subcommand as an ArgumentBuilder.
     *
     * @return the built subcommand as an ArgumentBuilder
     */
    public ArgumentBuilder<BCommandSourceStack, ?> buildSubcommand() {
        ArgumentBuilder<BCommandSourceStack, ?> builder = this.getSubcommand();
        this.build(builder);

        for (BSubcommand subcommand : subcommands) {
            builder.then(subcommand.buildSubcommand());
        }

        return builder;
    }

    /**
     * Registers a subcommand for the BClientCommand.
     *
     * @param subcommand  the subcommand to register
     * @return the BClientCommand instance
     */
    public BSubcommand registerSubcommand(BSubcommand subcommand) {
        subcommands.add(subcommand);

        return this;
    }

}
