package dev.boxadactle.boxlib.test;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.api.subcommand.*;
import dev.boxadactle.boxlib.command.api.BCommand;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.keybind.KeybindHelper;
import dev.boxadactle.boxlib.test.config.ExampleConfigClass;
import dev.boxadactle.boxlib.test.keybind.Keybindings;
import dev.boxadactle.boxlib.translate.Language;
import dev.boxadactle.boxlib.translate.Translator;
import dev.boxadactle.boxlib.util.ModLogger;

public class TestMod {

    public static final String MOD_NAME = "Boxlib Test Mod";

    public static final String MOD_ID = "boxlibtestmod";

    public static final ModLogger LOGGER = new ModLogger(MOD_NAME);

    public static BConfigClass<ExampleConfigClass> CONFIG;

    public static void init() {
        LOGGER.info("Initializing " + MOD_NAME + "...");

        // make sure to register your config class like this
        CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

        // make sure to register your client commands like this
        BCommandManager.register(BCommand.create("funny", (context) -> {
                        TestMod.LOGGER.player.info("You are funny!");

                        return 0;
                }).registerSubcommand(
                        new BasicSubcommand("not", (context) -> {
                            TestMod.LOGGER.player.info("You are not funny!");

                            return 0;
                        }).registerSubcommand(new BasicSubcommand("sike", context -> {
                            TestMod.LOGGER.player.info("Sike! You are funny!");

                            return 0;
                        }))
                ).registerSubcommand(
                        new BLabelSubcommand("adverb", (context) -> {
                            TestMod.LOGGER.player.info("You did not specify an adverb!");

                            return 0;
                        }, new StringSubcommand("adverb", (context, string) -> {
                            TestMod.LOGGER.player.info("You are " + string + " funny!");

                            return 0;
                        }))
                ).registerSubcommand(new BLabelSubcommand("boolean", new BooleanSubcommand("bool", (context, bool) -> {
                    TestMod.LOGGER.player.info("You said " + (bool ? "yes!" : "no :("));

                    return 0;
                }))).registerSubcommand(new BLabelSubcommand("double", new DoubleSubcommand("double", (context, d) -> {
                    TestMod.LOGGER.player.info("An atom is " + d + " (double) millimeters large");

                    return 0;
                }))).registerSubcommand(new BLabelSubcommand("float", new FloatSubcommand("float", (context, f) -> {
                    TestMod.LOGGER.player.info("New years eve was " + f + " seconds ago");

                    return 0;
                }))).registerSubcommand(new BLabelSubcommand("integer", new DoubleSubcommand("int", (context, i) -> {
                    TestMod.LOGGER.player.info("You have read " + i + " books");

                    return 0;
                }))).registerSubcommand(new BLabelSubcommand("long", new DoubleSubcommand("long", (context, l) -> {
                    TestMod.LOGGER.player.info("The universe has existed for " + l + " years");

                    return 0;
                })))
        );

        Keybindings.init();

        String message = "Test keybind 1 is bound to " + KeybindHelper.getBoundKey(Keybindings.TEST_KEYBIND);

        // you can use google translate to translate messages
        String translated = Translator.translate(message, Language.SPANISH);
        LOGGER.info(translated);
    }

}
