package dev.boxadactle.boxlib.test.command;

import dev.boxadactle.boxlib.command.api.BClientCommand;
import dev.boxadactle.boxlib.test.TestMod;

public class FunnyClientCommand {

    public static BClientCommand create() {
        BClientCommand command = BClientCommand.create("funny", (context) -> {
            TestMod.LOGGER.player.info("You are funny!");

            return 0;
        }).registerSubcommand("not", (context) -> {
            TestMod.LOGGER.player.info("You are not funny!");

            return 0;
        }).registerSubcommand(new AdverbSubcommand());

        return command;
    }

}
