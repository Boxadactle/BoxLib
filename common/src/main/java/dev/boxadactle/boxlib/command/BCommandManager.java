package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.boxadactle.boxlib.command.api.BCommand;

/**
 * The BCommandManager class is responsible for managing commands in the BoxLib mod.
 * It provides methods for registering commands and creating argument builders.
 */
public class BCommandManager {

    /**
     * Registers a BClientCommand with the command manager.
     *
     * @param command the command to register
     */
    public static void register(BCommand command) {
        BCommandImpl.addCommand(command);
    }

    /**
     * Creates a literal argument builder with the specified name.
     *
     * @param name the name of the literal argument
     * @return the created LiteralArgumentBuilder
     */
    public static LiteralArgumentBuilder<BCommandSourceStack> literal(String name) {
        return LiteralArgumentBuilder.literal(name);
    }

    /**
     * Creates a required argument builder with the specified name and type.
     *
     * @param name the name of the argument
     * @param type the type of the argument
     * @param <T> the type of the argument
     * @return the created RequiredArgumentBuilder
     */
    public static <T> RequiredArgumentBuilder<BCommandSourceStack, T> argument(String name, ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }

}
