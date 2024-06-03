package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.boxadactle.boxlib.command.api.BClientCommand;

public class BCommandManager {

    public static void register(BClientCommand command) {
        BCommandImpl.addCommand(command);
    }

    public static LiteralArgumentBuilder<BCommandSourceStack> literal(String name) {
        return LiteralArgumentBuilder.literal(name);
    }

    public static <T> RequiredArgumentBuilder<BCommandSourceStack, T> argument(String name, ArgumentType<T> type) {
        return RequiredArgumentBuilder.argument(name, type);
    }

}
