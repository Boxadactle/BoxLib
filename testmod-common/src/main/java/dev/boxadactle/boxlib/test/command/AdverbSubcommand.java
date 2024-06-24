package dev.boxadactle.boxlib.test.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.command.api.BClientSubcommand;
import dev.boxadactle.boxlib.test.TestMod;

public class AdverbSubcommand implements BClientSubcommand {
    @Override
    public ArgumentBuilder<BCommandSourceStack, ?> getSubcommand() {
        return BCommandManager.argument("adverb", StringArgumentType.string());
    }

    @Override
    public void build(ArgumentBuilder<BCommandSourceStack, ?> builder) {
        builder.executes(context -> {
            String adjective = StringArgumentType.getString(context, "adverb");

            TestMod.LOGGER.player.info("You are " + adjective + " funny!");

            return 0;
        });
    }
}
