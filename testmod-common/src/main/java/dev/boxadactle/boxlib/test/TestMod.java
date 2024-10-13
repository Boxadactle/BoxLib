package dev.boxadactle.boxlib.test;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.command.api.BCommand;
import dev.boxadactle.boxlib.command.api.subcommand.*;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.keybind.KeybindHelper;
import dev.boxadactle.boxlib.math.geometry.Box;
import dev.boxadactle.boxlib.math.geometry.Vec3;
import dev.boxadactle.boxlib.rendering.RenderQueue;
import dev.boxadactle.boxlib.rendering.renderers.BoxRenderer;
import dev.boxadactle.boxlib.rendering.renderers.TextRenderer;
import dev.boxadactle.boxlib.rendering.renderers.OutlineRenderer;
import dev.boxadactle.boxlib.rendering.renderers.PathRenderer;
import dev.boxadactle.boxlib.test.config.ExampleConfigClass;
import dev.boxadactle.boxlib.test.keybind.Keybindings;
import dev.boxadactle.boxlib.translate.Language;
import dev.boxadactle.boxlib.translate.Translator;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.WorldUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.AABB;
import oshi.util.tuples.Pair;

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

        // render in 3 dimensions like this
        TextRenderer renderer = new TextRenderer(false)
                .setPos(new Vec3<>(0.0, 100.0, 0.0))
                .setText(Component.literal("Hello, world!"))
                .setSize(0.3F)
                .setColor(GuiUtils.BLUE)
                .setCentered(true)
                .setXray(false);

        OutlineRenderer outlineRenderer = new OutlineRenderer(false)
                .setCube(new Box<>(-1.0, 105.0, -1.0, 1.0, 2.0, 1.0))
                .setColor(GuiUtils.YELLOW)
                .setAlpha(0.5F);

        PathRenderer pathRenderer = new PathRenderer(false)
                .setPoints(
                        new Vec3<>(-1.0, 100.0, -1.0),
                        new Vec3<>(1.0, 103.0, -1.0),
                        new Vec3<>(1.0, 107.0, 1.0),
                        new Vec3<>(-1.0, 112.0, 1.0),
                        new Vec3<>(-1.0, 114.0, -1.0)
                )
                .setColor(GuiUtils.RED);

        BoxRenderer boxRenderer = new BoxRenderer(false)
                .setCube(new BlockPos(10, 100, 0))
                .setColor(GuiUtils.GOLD)
                .setAlpha(0.3F);

        RenderQueue.addRenderer(renderer);
        RenderQueue.addRenderer(outlineRenderer);
        RenderQueue.addRenderer(pathRenderer);
        RenderQueue.addRenderer(boxRenderer);
        RenderQueue.addRenderer(() -> {
            net.minecraft.world.phys.Vec3 playerPos = WorldUtils.getCamera().position().add(10.0, 0.0, 0.0);

            BoxRenderer awayRenderer = new BoxRenderer(false)
                    .setCube(new AABB(new BlockPos((int) playerPos.x, (int) playerPos.y, (int) playerPos.z)))
                    .setColor(GuiUtils.GOLD)
                    .setAlpha(0.3F);

            return new Pair<>(awayRenderer, true);
        });

        RenderQueue.addRenderer(() -> {
            net.minecraft.world.phys.Vec3 playerPos = WorldUtils.getCamera().position();

            TextRenderer north = new TextRenderer(false)
                    .setPos(new Vec3<>(playerPos.x, playerPos.y + 1.0, playerPos.z - 10.0))
                    .setText(Component.literal("N"))
                    .setSize(0.3F)
                    .setColor(GuiUtils.RED)
                    .setCentered(true)
                    .setXray(true);

            return new Pair<>(north, true);
        });

        RenderQueue.addRenderer(() -> {
            net.minecraft.world.phys.Vec3 playerPos = WorldUtils.getCamera().position();

            TextRenderer east = new TextRenderer(false)
                    .setPos(new Vec3<>(playerPos.x + 10.0, playerPos.y + 1.0, playerPos.z))
                    .setText(Component.literal("E"))
                    .setSize(0.3F)
                    .setColor(GuiUtils.GREEN)
                    .setCentered(true)
                    .setXray(true);

            return new Pair<>(east, true);
        });

        RenderQueue.addRenderer(() -> {
            net.minecraft.world.phys.Vec3 playerPos = WorldUtils.getCamera().position();

            TextRenderer south = new TextRenderer(false)
                    .setPos(new Vec3<>(playerPos.x, playerPos.y + 1.0, playerPos.z + 10.0))
                    .setText(Component.literal("S"))
                    .setSize(0.3F)
                    .setColor(GuiUtils.BLUE)
                    .setCentered(true)
                    .setXray(true);

            return new Pair<>(south, true);
        });

        RenderQueue.addRenderer(() -> {
            net.minecraft.world.phys.Vec3 playerPos = WorldUtils.getCamera().position();

            TextRenderer west = new TextRenderer(false)
                    .setPos(new Vec3<>(playerPos.x - 10.0, playerPos.y + 1.0, playerPos.z))
                    .setText(Component.literal("W"))
                    .setSize(0.3F)
                    .setColor(GuiUtils.YELLOW)
                    .setCentered(true)
                    .setXray(true);

            return new Pair<>(west, true);
        });
    }

}
